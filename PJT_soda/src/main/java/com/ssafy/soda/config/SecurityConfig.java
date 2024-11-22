package com.ssafy.soda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ssafy.soda.security.jwt.JwtAuthenticationFilter;
import com.ssafy.soda.security.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity // JWT 토큰 기반의 인증 시스템을 구현
/*
 * CSRF 보호 기능을 끔 세션을 사용하지 않고 상태를 저장하지 않는 방식 사용 /api/auth/**와 /api/public/** 경로는
 * 누구나 접근 가능 나머지 경로는 인증된 사용자만 접근 가능 비밀번호는 BCrypt로 암호화
 */
@RequiredArgsConstructor // final이나 @NonNull이 붙은 필드만 가지고 생성자를 자동으로 만들어줍
public class SecurityConfig {
	
	private final JwtTokenProvider jwtTokenProvider;
//	private final UserDetailsService userDetailsService; ?? 

	//보안 요원 같은 메서드임. 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			// CSRF 공격 방어 기능을 끔 (REST API라서 필요없음)

			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			// 세션을 사용하지 않음 (JWT 사용할 거니까)

			.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/api/auth/**").permitAll()
			// "/api/auth/"로 시작하는 경로는 누구나 접근 가능
			.requestMatchers("/api/public/**").permitAll()
			// "/api/public/"로 시작하는 경로도 누구나 접근 가능
			.anyRequest().authenticated();
			// 나머지 경로는 인증된 사용자만 접근 가능
			})
			.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), //JwtAuthenticationFilter 가 출입카드 검사 직원할거예요~!
				UsernamePasswordAuthenticationFilter.class);
				// JWT 토큰 검사하는 필터를 추가

		return http.build();
	}
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
			/*
			 * // BCryptPasswordEncoder가 하는 일 
			 * String 암호화된비밀번호 = BCryptPasswordEncoder.encode("1234"); 
			 * // 결과: "$2a$10$ABCD...xyz" (매번 다른 값 나옴)
			 * 해커가 DB를 털어도 원래 비밀번호는 알 수 없게!
				비밀번호는 알 수 없어도 로그인 확인은 가능하게!
				이렇게 비교 가능함. 
				BCryptPasswordEncoder.matches("1234", "$2a$10$ABC...") // true 
			 */	    
	        }
	
	
	
	
	
	
	
	
	
	
	
}
