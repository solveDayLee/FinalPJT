package com.ssafy.soda.controller;

import java.security.interfaces.RSAKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.soda.jwt.JwtUtil;
import com.ssafy.soda.model.dto.User;
import com.ssafy.soda.model.service.UserService;

@RestController
@RequestMapping("/etco")
//@CrossOrigin("*") -> webconfig에서 전역으로 cors설정 주고 있어서 안해줘도 됨.
public class ClientUserController {
	private final UserService userService;
	private final JwtUtil jwtUtil;
	public ClientUserController(UserService userService, JwtUtil jwtUtil) {
		super();
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> userList() {
		List<User> list = userService.getUserList();
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> write(@RequestBody User user) {
		System.out.println("회원가입: " + user);
		if(userService.signup(user)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("사용자 회원 추가 성공");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("사용자 회원 추가 실패");
	}
	
	@PostMapping("/login")
//	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
//		Map<String, Object> result = new HashMap<>();
//		User loginUser = userService.login(user.getUserId(), user.getPassword(), user.getUserNo());
//		
//		 // 디버깅 로그 추가
//	    if (loginUser != null) {
//	        System.out.println("로그인 성공: " + loginUser.getUserId());
//	        System.out.println("사용자 번호(userNo): " + loginUser.getUserNo());
//	    } else {
//	        System.out.println("로그인 실패: " + user.getUserId());
//	    }
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {	
		System.out.println("컨트롤러의 login 진입! user: " + user);
		boolean isUser = userService.verify(user);
		
		System.out.println("isUser : " + isUser);
		
		Map<String, Object> result = new HashMap<>();
		if(isUser) {
			User loginUser = userService.getUserById(user.getUserId());
			
			System.out.println("로그인성공 "+ user.getUserId());
			//role 정보 포함하여 토큰 생성 (관리자, 사용자 역할)
			
			System.out.println("로그인 시도 유저: " + loginUser.getUserId());
	        System.out.println("유저 권한: " + loginUser.getRole());
			
			String role = loginUser.getRole() != null ? "ROLE_" + loginUser.getRole() : "USER";

//	        // role이 이미 ROLE_로 시작하는지 확인
//	        String role = loginUser.getRole();
//	        if (!role.startsWith("ROLE_")) {
//	            role = "ROLE_" + role;
//	        }
	        
	        System.out.println("최종 권한: " + role);
			
			if("ROLE_ADMIN".equals(role)) {
				result.put("message", "admin login success");
//				result.put("redirectUrl", "/admin/main");
				result.put("redirectUrl", "http://localhost:8080/admin/main");
				result.put("access-token", jwtUtil.createToken(loginUser.getUserId(), role, loginUser.getUserNo())); // JWT 토큰 저장
				result.put("role", role);
				
//				 // 관리자에게도 토큰 생성
//			    String token = jwtUtil.createToken(loginUser.getName(), role, loginUser.getUserNo());
//			    result.put("access-token", token); // 추가
//			    
//				System.out.println(token);
//	            return new ResponseEntity<>(result, HttpStatus.OK);
//			}
//			String token = jwtUtil.createToken(loginUser.getName(), role, loginUser.getUserNo());
//			
//			//일반 사용자는 jwt처리
////			result.put("message", "login성공"); //상태 메시지 저장
//			//jwtUtil.createToken()을 호출할 때 role 파라미터를 함께 전달
//			result.put("access-token", token); // JWT 토큰 저장
			
				System.out.println("응답 데이터 (관리자): " + result); // 디버깅용
	            return new ResponseEntity<>(result, HttpStatus.OK);
			}
			result.put("message", "login성공"); //상태 메시지 저장
			result.put("redirectUrl", "http://localhost:5173/"); // 그냥 명시해주기
			jwtUtil.createToken(loginUser.getName(), role, loginUser.getUserNo());
			result.put("access-token", jwtUtil.createToken(loginUser.getUserId(), role, loginUser.getUserNo())); // JWT 토큰 저장
			
			result.put("role", role); //클라이언트에게 role 정보 저장
			
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
					
		}
		result.put("message", "login실패");
		return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
	
	}
	
		
	
}
