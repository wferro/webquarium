package br.com.kayala.webquarium.web.infrastructure.config;

import br.com.kayala.webquarium.core.infrastructure.config.JpaConfig;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) {
		WebApplicationContext rootContext = createRootContext(servletContext);

		configureSpringMvc(servletContext, rootContext);
		configureSpringRestMvc(servletContext, rootContext);
//		configureSpringSecurity(servletContext, rootContext);
	}

	private WebApplicationContext createRootContext(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(JpaConfig.class);

		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.setInitParameter("defaultHtmlEscape", "true");

		return rootContext;
	}

	private void configureSpringMvc(ServletContext servletContext, WebApplicationContext rootContext) {
		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(MvcConfig.class);
		mvcContext.setParent(rootContext);

		ServletRegistration.Dynamic appServlet = servletContext.addServlet("webservices", new DispatcherServlet(
				mvcContext));
		appServlet.setLoadOnStartup(1);
		Set<String> mappingConflicts = appServlet.addMapping("/services/*");

		if (!mappingConflicts.isEmpty()) {
			throw new IllegalStateException("'webservice' cannot be mapped to '/'");
		}
	}

	private void configureSpringRestMvc(ServletContext servletContext, WebApplicationContext rootContext) {
		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(RestConfig.class);
		mvcContext.setParent(rootContext);

		ServletRegistration.Dynamic appServlet = servletContext.addServlet("rest-exporter", new DispatcherServlet(
				mvcContext));
		appServlet.setLoadOnStartup(1);
		Set<String> mappingConflicts = appServlet.addMapping("/data-rest/*");

		if (!mappingConflicts.isEmpty()) {
			throw new IllegalStateException("'webservice' cannot be mapped to '/'");
		}
	}

//	private void configureSpringSecurity(ServletContext servletContext, WebApplicationContext rootContext) {
//		FilterRegistration.Dynamic springSecurity = servletContext.addFilter("springSecurityFilterChain",
//				new DelegatingFilterProxy("springSecurityFilterChain", rootContext));
//		springSecurity.addMappingForUrlPatterns(null, true, "/*");
//	}

}
