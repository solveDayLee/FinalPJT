package com.ssafy.soda.controller;

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
	
	@GetMapping("/users")
	public ResponseEntity<?> userList() {
		List<User> list = userService.getUserList();
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> write(@RequestBody User user) {
		if(userService.signup(user)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("사용자 회원 추가 성공");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("사용자 회원 추가 실패");
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		Map<String, Object> result = new HashMap<>();
		User loginUser = userService.login(user.getUserId(), user.getPassword());
		
		if(loginUser != null) {
			result.put("message", "login성공"); //상태 메시지 저장
			result.put("access-token", jwtUtil.createToken(loginUser.getName())); // JWT 토큰 저장
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);  // 저장된 메시지와 토큰을 클라이언트에게 전송
		}
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
