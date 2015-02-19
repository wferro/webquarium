package br.com.kayala.webquarium.web.infrastructure.config;

import br.com.kayala.webquarium.web.WebConstants;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableEntityLinks
@ComponentScan(basePackages = {WebConstants.CONTROLLER_PACKAGE})
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		converters.add(jackson2Converter());
	}

	@Bean
	public MappingJackson2HttpMessageConverter jackson2Converter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setPrefixJson(true);
		converter.setPrefixJson(false);

		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(new MediaType("application", "json"));
		converter.setSupportedMediaTypes(mediaTypes);

		converter.setObjectMapper(objectMapper());

		return converter;
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		objectMapper.setSerializationInclusion(Include.ALWAYS);
		return objectMapper;
	}
}
