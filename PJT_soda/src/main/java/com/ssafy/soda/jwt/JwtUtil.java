package com.ssafy.soda.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtil {

	 @Value("${jwt.secret}")  // application.properties에서 값을 가져옴
	    private String key;
	    private SecretKey secretKey;

	    @PostConstruct  // 객체 생성 후 초기화
	    public void init() {
	        secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
	    }
	    
	    
	    
	    // 토큰 생성
	    public String createToken(String name, String role, Integer userNo) {
	    	  if (role!= null && !role.startsWith("ROLE_")) {
	    	        role = "ROLE_" + role;
	    	    }
	    	
	    	
	        return Jwts.builder()
	                .setHeaderParam("typ", "JWT")  // header() 대신 setHeaderParam 사용
	                .claim("name", name)
	                .claim("role", role)
	                .claim("userNo", userNo) // userNo 추가
	                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60))
	                .signWith(secretKey)
	                .compact();
	    }

	    // 토큰 검증
	    public Jws<Claims> validate(String token) {
	        return Jwts.parserBuilder()
	                .setSigningKey(secretKey)
	                .build()
	                .parseClaimsJws(token);  // parseSignedClaims 대신 parseClaimsJws 사용
	    }
	    
	    //role정보 가져오는 메서드 추가
	    public String getRole(String token) {
	    	Claims claims = Jwts.parserBuilder()
	    			.setSigningKey(secretKey)
	    			.build()
	    			.parseClaimsJws(token)
	    			.getBody();
	    	return claims.get("role", String.class);
	    }
	    
	    //토큰에서 사용자 이름 추출하는 메서드 추가
	    public Integer getUserNo(String token) {
	    	Claims claims = Jwts.parserBuilder()
	    			.setSigningKey(secretKey)
	    			.build()
	    			.parseClaimsJws(token)
	    			.getBody();
	    	return claims.get("userNo", Integer.class);
	    }



		public String getUserId(String actualToken) {
			// TODO Auto-generated method stub
			return null;
		}
	    
	    
}
