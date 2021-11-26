package kosta.mvc.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class AppConfig {
	
	@Bean
	public SimpleMappingExceptionResolver getExceptionMapping() {
		SimpleMappingExceptionResolver mappingEx = new SimpleMappingExceptionResolver();
		Properties pro = new Properties();
		pro.put("Exception", "error/errorView");
		mappingEx.setExceptionMappings(pro);
		return mappingEx;
	}
}
