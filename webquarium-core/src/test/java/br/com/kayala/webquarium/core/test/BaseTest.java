package br.com.kayala.webquarium.core.test;

import br.com.kayala.webquarium.core.Constants;
import br.com.kayala.webquarium.core.infrastructure.config.JpaConfig;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * base test class
 *
 * @author kayala
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class})
public class BaseTest {

	@BeforeClass
	public static void setupJndi() throws NamingException {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/webquarium");
		dataSource.setUsername("webquarium");
		dataSource.setPassword("D0ct0r!!!");

		SimpleNamingContextBuilder.emptyActivatedContextBuilder();
		Context context = new InitialContext();
		context.bind(Constants.DB_JNDI_NAME, dataSource);
	}

}
