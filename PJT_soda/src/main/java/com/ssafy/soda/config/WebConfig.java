package com.ssafy.soda.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // API 경로 패턴
                .allowedOrigins("http://localhost:8080")  // Vue.js 개발 서버 주소
             // 모든 HTTP 메서드 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE")
             // 모든 헤더 허용
               .allowedHeaders("*")
               // 인증 정보 허용
               .allowCredentials(true)
            // preflight 캐시 시간
                .maxAge(3600);
    }
}