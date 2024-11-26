package com.ssafy.soda.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.soda.interceptor.JwtInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Value("${vue.base.url}")
	private String vueBaseUrl;
	
	private JwtInterceptor jwtInterceptor;
	
	//생성자 의존성 주입
	public WebConfig(JwtInterceptor jwtInterceptor) {
		super();
		this.jwtInterceptor = jwtInterceptor;
	}

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
////        .allowedOrigins("http://localhost:5173") // Vue.js 개발 서버 주소
////        .allowedOrigins(vueBaseUrl) // Vue.js 개발 서버 주소
//        .allowedOriginPatterns("*")  // allowedOrigins 대신 allowedOriginPatterns 사용
//        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //OPTIONS 추가
//        .allowedHeaders("*")
//        .exposedHeaders("access-token") //JWT 토큰 헤더 노출 설정 추가
//        .allowCredentials(true);
//		
//	}
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**")
	        .allowedOriginPatterns("*")
	        .allowedMethods("*")
	        .allowedHeaders("*")
	        .exposedHeaders("access-token")  // JWT 토큰용으로 필요
	        .allowCredentials(true);
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor)
		.addPathPatterns("/etco/**", "/admin/**") //etco로 시작하는 모든 경로에 인터셉터 적용
		.excludePathPatterns("/etco/login", "/etco/signup", "/etco/board", "/admin/*"); //로그인, 회원가입, 전체리스트 제외
	}
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/uploads/**")
	                .addResourceLocations("file:src/main/resources/static/uploads/");
	    }
	
}

