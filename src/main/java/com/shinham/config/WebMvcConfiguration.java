package com.shinham.config;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	
	@Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	    }
 
 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginRequiredInterceptor()).addPathPatterns("/**")
		.excludePathPatterns(Arrays.asList("/", "/login.html", "/user/login","/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg",
				                   "/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/**/*.svg"));
	}
}
