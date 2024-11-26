package com.ssafy.soda.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.crypto.AlgorithmMethod;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
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
	    
//	    public JwtUtil() {
//	    	KeyGenerator keyGenerator = KeyGenerator.getInstance("algorithm", "HmacSHA256");
//	    	secretKey = keyGenerator.generateKey();
//	    }
	    
	    
	    // 토큰 생성
	    public String createToken(String userId, String role, Integer userNo) {
//	    public String createToken(String userId, String role) {
	    	  if (role!= null && !role.startsWith("ROLE_")) {
	    	        role = "ROLE_" + role;
	    	    }
	    	
	    	
	        return Jwts.builder()
	                .setHeaderParam("typ", "JWT")  // header() 대신 setHeaderParam 사용
	                .setSubject(userId)  // userId를 subject로 설정
	                .claim("userId", userId)
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

		public String extractUserName(String token) {
//			return extractClaim(token, Claims::getSubject);
			Claims claims = extractAllClaims(token);
			return claims.getSubject();  // subject에서 userId 추출
		}

		private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
			final Claims claims = extractAllClaims(token);
			return claimResolver.apply(claims);
		}

		private Claims extractAllClaims(String token) {
			return Jwts.parserBuilder()
					.setSigningKey(secretKey)
					.build().parseClaimsJws(token).getBody();
		}

		public boolean validateToken(String token, UserDetails userDetails) {
			final String userName = extractUserName(token);
			return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
		}

		private boolean isTokenExpired(String token) {
			return extractExpiration(token).before(new Date());
		}

		private Date extractExpiration(String token) {
			return extractClaim(token, Claims::getExpiration);
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



//		public String getUserId(String actualToken) {
//			// TODO Auto-generated method stub
//			return null;
//		}
	    
	    
}
