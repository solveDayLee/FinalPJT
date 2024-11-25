package com.ssafy.soda.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.ssafy.soda.jwt.JwtAuthenticationFilter;
@Configuration
public class SecurityConfig {
	
	private final UserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, UserDetailsService userDetailsService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
//            		.requestMatchers("/admin/main").authenticated()  // admin 메인 페이지는 인증 필요
            		.requestMatchers("/admin/main").permitAll()
//            		.requestMatchers("/admin/main").hasAuthority("ROLE_ADMIN")
//                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/login", "/signup", "/etco/**", "/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest().permitAll() //permitAll() 원래 authenticated() 이어야 함. 
            )
            .csrf(csrf -> csrf.disable())
//            .formLogin(form -> form
//                .loginPage("/admin/adminLogin")
//                .loginProcessingUrl("/admin/login")
//                .defaultSuccessUrl("/admin/main", true)  // true를 추가하여 무조건 이동하도록 설정
//                .permitAll()
//            ) // formLogin 설정 제거 (REST API 방식이므로 필요없음)

            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        //(REST API 호출을 위해)
        http.cors(cors -> cors.configurationSource(request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(Arrays.asList("*"));  // 모든 출처 허용
            config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            config.setAllowedHeaders(Arrays.asList("*"));
            return config;
        }));
        
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } // 최근 방식임. 

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    	return config.getAuthenticationManager();
    }
    
}


