package br.com.kayala.webquarium.web.infrastructure.config;

import br.com.kayala.webquarium.web.WebConstants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@ComponentScan(basePackages = { WebConstants.REST_PACKAGE })
public class RestConfig extends RepositoryRestMvcConfiguration {



}
