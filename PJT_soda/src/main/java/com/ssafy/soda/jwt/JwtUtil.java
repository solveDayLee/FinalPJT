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
	    public String createToken(String name) {
	        return Jwts.builder()
	                .setHeaderParam("typ", "JWT")  // header() 대신 setHeaderParam 사용
	                .claim("name", name)
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
	    
	    
}
