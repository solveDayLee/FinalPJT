package com.ssafy.soda.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.soda.jwt.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	//멤버십 카드 확인
	private final String HEADER_AUTH = "access-token";
	private final JwtUtil jwtUtil;

	public JwtInterceptor(JwtUtil jwtUtil) {
		super();
		this.jwtUtil = jwtUtil;
	}

	public boolean preHandle(HttpServletRequest rq, HttpServletResponse rs, Object handeler) throws Exception {

		// 로그인, 회원가입은 토큰 검사 제외
		String requestURI = rq.getRequestURI();
		if (requestURI.equals("/etco/login") || requestURI.equals("/etco/signup")
				|| requestURI.equals("/etco/board")) {  // 게시판 목록 보기 추가
			return true;
		}

		// OPTIONS 요청 허용
		if (rq.getMethod().equals("OPTIONS")) {
			return true;
		}

		// 토큰 확인
		//카드가 있고 유효하다면 통과, 없거나 유효하지 않다면 접근을 거부
		String token = rq.getHeader(HEADER_AUTH);
		if (token != null) {
			jwtUtil.validate(token);
			
			//admin 페이지 접근 시 권한 체크
			if(requestURI.startsWith("/admin")) {
				//토큰에서 role정보 가져오기
				String roleString = jwtUtil.getRole(token);
			}
			
			return true;
		}
		throw new Exception("유효하지 않은 접근입니다.");

	}

}
