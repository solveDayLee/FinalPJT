package com.ssafy.soda.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.soda.jwt.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	// 멤버십 카드 확인
	private final String HEADER_AUTH = "Authorization";
	private final JwtUtil jwtUtil;

	public JwtInterceptor(JwtUtil jwtUtil) {
		super();
		this.jwtUtil = jwtUtil;
	}

	public boolean preHandle(HttpServletRequest rq, HttpServletResponse rs, Object handeler) throws Exception {

		// 로그인, 회원가입은 토큰 검사 제외
		String requestURI = rq.getRequestURI();
		if (requestURI.equals("/etco/login") || requestURI.equals("/etco/signup")
				|| requestURI.equals("/etco/board") || requestURI.equals("/admin/login") 
                || requestURI.equals("/admin/adminLogin")) {  // 게시판 목록 보기 추가
			// 관리자 로그인 관련 경로 추가
			return true;
		}

		// OPTIONS 요청 허용
		if (rq.getMethod().equals("OPTIONS")) {
			return true;
		}

		// 토큰 확인
		//카드가 있고 유효하다면 통과, 없거나 유효하지 않다면 접근을 거부
		String token = rq.getHeader(HEADER_AUTH);
	      // Bearer 토큰 처리
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // "Bearer " 제거
        }
        
        if(token != null) {
        	try {
        		jwtUtil.validate(token);
                // admin 페이지 접근 시 권한 체크
                if (requestURI.startsWith("/admin")) {
                    String role = jwtUtil.getRole(token);
                    if (role == null || !"ROLE_ADMIN".equals(role)) {
                        throw new Exception("관리자 권한이 없습니다.");
                    }
                }
                
                return true;
            } catch (Exception e) {
                System.out.println("토큰 검증 실패: " + e.getMessage());
                throw new Exception("유효하지 않은 토큰입니다.");
            }
        }
        
        System.out.println("토큰이 없음: " + requestURI);
        throw new Exception("유효하지 않은 접근입니다.");
    }
}