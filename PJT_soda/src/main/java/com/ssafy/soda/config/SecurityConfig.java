package com.ssafy.soda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ssafy.soda.jwt.JwtAuthenticationFilter;
@Configuration
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
            		.requestMatchers("/admin/main").authenticated()  // admin 메인 페이지는 인증 필요
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/login", "/signup", "/etco/**", "/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest().permitAll()
            )
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form
                .loginPage("/admin/adminLogin")
                .loginProcessingUrl("/admin/login")
                .defaultSuccessUrl("/admin/main", true)  // true를 추가하여 무조건 이동하도록 설정
                .permitAll()
            )
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            )
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}


//@Configuration
//public class SecurityConfig {
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(authorize -> authorize
//                // 관리자 권한이 필요한 경로 설정
//                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
//                // 로그인, 회원가입 관련 엔드포인트는 모든 사용자 접근 허용
//                .requestMatchers("/login", "/signup", "/etco/**", "/css/**", "/js/**", "/images/**").permitAll()
//                .anyRequest().permitAll()
//            )
//            // CSRF 보호 비활성화 (JWT 사용으로 인해)
//            .csrf(csrf -> csrf.disable())
//            // 폼 로그인 설정
//            .formLogin(form -> form
//                .loginPage("/admin/adminLogin")
//                .loginProcessingUrl("/admin/login")
//                .successHandler((request, response, authentication) -> {
//                	// admin으로 로그인했을 때의 처리
//                    if ("admin".equals(authentication.getName())) {
//                        response.sendRedirect("/admin/main");
//                    }
//                })
//                .failureUrl("/admin/adminLogin?error")  // 실패시 다시 로그인 페이지로
//                .permitAll()
//            )
//            // JWT 사용을 위한 세션 설정
//            .sessionManagement(session -> 
//                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            )
//            // JWT 인증 필터 추가
//            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//}
