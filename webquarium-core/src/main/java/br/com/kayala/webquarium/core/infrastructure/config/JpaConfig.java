package br.com.kayala.webquarium.core.infrastructure.config;

import br.com.kayala.webquarium.core.Constants;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * spring data jpa annotation based config class
 *
 * @author kayala
 */
@Configuration
@EnableJpaRepositories(basePackages = {Constants.REPOSITORY_PACKAGE})
@EnableTransactionManagement
@ComponentScan(basePackages = "br.com.kayala.webquarium")
public class JpaConfig {

	/**
	 * create bean validator bean
	 *
	 * @return validator bean
	 */
	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}

	/**
	 * load datasource config from JNDI
	 *
	 * @return Datasource bean
	 */
	@Bean
	public DataSource dataSource() {
		// configure and return the necessary JDBC DataSource
		JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
		dataSource.setJndiName(Constants.DB_JNDI_NAME);
		try {
			dataSource.afterPropertiesSet();
		} catch (IllegalArgumentException | NamingException ex) {
			Logger.getLogger(JpaConfig.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (DataSource) dataSource.getObject();
	}

	/**
	 * create and configure entity manager factory
	 *
	 * @return Entity manager factory bean
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(Constants.ENTITY_PACKAGE);
		factory.setJpaProperties(connectionProperties());
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public FullTextEntityManager fullTextEntityManager(EntityManager em) {
		return Search.getFullTextEntityManager(em);
	}
	
	/**
	 * create and configure transaction manager bean
	 *
	 * @param emf entity manager factory bean
	 * @return transaction manager bean
	 */
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}

	/**
	 * configure persistence exception translator
	 *
	 * @return persistence exception translator bean
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties connectionProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.search.default.directory_provider", "filesystem");
		properties.setProperty("hibernate.search.default.indexBase", "/var/lucene/indexes");
		properties.setProperty("hibernate.search.analyzer", "br.com.kayala.webquarium.core.infrastructure.analyzer.PortugueseAnalyzer");
		return properties;
	}

}
