package com.api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.api.api.logging.CustomRequestInterceptor;

@Configuration
@EnableAsync
public class RequestAppConfig implements WebMvcConfigurer {

	@Autowired
	private CustomRequestInterceptor customRequestInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(customRequestInterceptor).addPathPatterns("/**/thing/**/");
	}
}