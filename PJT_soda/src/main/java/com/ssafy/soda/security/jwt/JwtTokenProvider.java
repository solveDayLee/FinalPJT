package com.ssafy.soda.security.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
@Component
public class JwtTokenProvider {

	@Value("${jwt.secret}")
	private String secretKey;

	private SecretKey key;

	@Value("${jwt.expiration}")
	private long validityInMilliseconds;

	@PostConstruct // 위에 의존성이 주입되고 나서 실행됨.
	protected void init() { // 비밀키 만들기
		// 첫번째 방법: claud 추천 보다는 수업시간에 배운 두번째가 더 강력한 보안
//		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		this.key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
	}

	//토큰 만들기 
	public String createToken(String username, List<String> roles) {
//		Claims claims = Jwts.claims().subject(username).build(); //옛날 방법

		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMilliseconds);

		return Jwts.builder()
				.subject(username) // 직접 subject 설정 = 토큰의 주인
				.claim("roles", roles) // 직접 claim 추가 = 표준 클레임이 아니라 우리가 커스텀으로 넣는 정보임. 
				.issuedAt(now) // 토큰 발급 시간 = 이걸 기준으로 오래된 토큰 무효화 가능
				.expiration(validity) // 만료시간
				.signWith(key)	//이 서명으로 나중에 위조인지 찐인지 구분 가능
				.compact(); // 만들어진 Jwt 를 잘 포장한다고 생각하기

	}
	/*
	 * // 예: 일반 사용자 roles = ["USER"]
	 * 
	 * // 예: 관리자 roles = ["ADMIN"]
	 * 
	 * // 예: 여러 권한을 가진 사용자 roles = ["USER", "MODERATOR"]
	 */
	
	//토큰 받으면 유저 이름 빼오기
	public String getUsername(String token) {
	    // 1. JWT 파서(해석기) 생성
	    return Jwts.parser()
	        .verifyWith(key)         // 우리의 비밀키로 검증
	        .build()                    // 파서 생성 완료
	        
	        // 2. 토큰 파싱 (해석)
	        .parseSignedClaims(token)      // 토큰을 해석함
	        
	        // 3. 내용물 꺼내기
	        .getPayload()                  // 토큰의 내용물(Claims) 가져오기
	        .getSubject();             // 그 중에서 subject(사용자이름) 가져오기
	}
	
	//토큰 유효한지 검사하기
	public boolean validateToken(String token) {
	    try {
	        // 1. 토큰 검증 시도
	        Jwts.parser()                     // JWT 파서 생성
	            .verifyWith(key)              // 우리의 비밀키로 검증
	            .build()
	            .parseSignedClaims(token);    // 토큰 파싱 시도
	        return true;                      // 성공하면 true 반환
	        
	    } catch (Exception e) {
	        return false;                     // 실패하면 false 반환
	    }
	}
	
	

}
