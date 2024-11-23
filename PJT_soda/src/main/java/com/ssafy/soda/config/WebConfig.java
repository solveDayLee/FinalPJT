package com.ssafy.soda.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
//        .allowedOrigins("http://192.168.210.73:5173") // Vue.js 개발 서버 주소
        .allowedOrigins("http://localhost:5173") // Vue.js 개발 서버 주소
        .allowedOrigins("http://192.168.210.73:5173") // Vue.js 개발 서버 주소
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);
	}
}

