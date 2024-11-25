package com.ssafy.soda.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ssafy.soda.model.service.MyUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private JwtUtil jwtUtil;
	private final MyUserDetailsService userDetailsService;

	public JwtAuthenticationFilter(JwtUtil jwtUtil, MyUserDetailsService userDetailsService) {
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
	}

//    @Autowired
//    ApplicationContext context;

//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                  HttpServletResponse response,
//                                  FilterChain filterChain) throws ServletException, IOException {
//    	
//    	String authHeader = request.getHeader("Authorization");
//    	String token = null;
//    	String username = null;
//    	
//    	if(authHeader != null && authHeader.startsWith("Bearer ")){
//    		token = authHeader.substring(7);
//    		username = jwtUtil.extractUserName(token);
//    	}
//        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(username);  // 직접 서비스 호출
//    		
//    		if(jwtUtil.validateToken(token, userDetails)) {
//    			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//    			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//    			SecurityContextHolder.getContext().setAuthentication(authToken);
//    			
//    		    // 여기에 관리자 권한 체크 추가
//                boolean isAdmin = userDetails.getAuthorities().stream()
//                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
//                    
//                // admin이 아닌 페이지에서 admin 페이지로 접근할 때 리다이렉트
//                if (isAdmin && request.getRequestURI().startsWith("/admin")) {
//                    response.sendRedirect("/admin/main");
//                    return;
//                }
//    		}
//    	}
//    	filterChain.doFilter(request, response);
//    }
	/*
	 * 전 코드와의 차이: 첫 번째 코드: 단순히 token의 유효성만 검사 두 번째 코드: token의 유효성과 함께 UserDetails
	 * 정보와 비교하여 더 엄격한 검증 수행
	 */

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");
		String token = null;
		String username = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			username = jwtUtil.extractUserName(token);

// 디버깅을 위한 로그
			System.out.println("Token found: " + token);
			System.out.println("Username: " + username);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			if (jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);

// 디버깅을 위한 로그
				

// admin 권한 체크 및 리다이렉션
				boolean isAdmin = userDetails.getAuthorities().stream()
						.anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

				System.out.println("Is Admin: " + isAdmin);
				System.out.println("Current URI: " + request.getRequestURI());

//// admin인 경우 무조건 리다이렉트
//				if (isAdmin) {
//					System.out.println("Redirecting to admin page...");
//					response.sendRedirect("http://localhost:8080/admin/main");
//					return;
//				}
				//무한루프 현상 해결
				if (isAdmin && !request.getRequestURI().equals("/admin/main")) {
				    System.out.println("Redirecting to admin page...");
				    response.sendRedirect("/admin/main");
				    return;
				}
				 System.out.println("User authorities: " + userDetails.getAuthorities());
	        } else {
	            // 토큰 검증 실패 시 로그 추가
	            System.out.println("JWT 토큰 검증 실패");
	        }
	    } else if (username == null) {
	        System.out.println("Authorization 헤더가 없거나 JWT 토큰을 찾을 수 없음");
	    
			
		}
		filterChain.doFilter(request, response);
	}
}