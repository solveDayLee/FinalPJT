package com.ssafy.soda.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.soda.jwt.JwtUtil;
import com.ssafy.soda.model.dto.Comment;
import com.ssafy.soda.model.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	private final CommentService commentService;
	private final JwtUtil jwtUtil;

	public CommentController(CommentService commentService, JwtUtil jwtUtil) {
		super();
		this.commentService = commentService;
		this.jwtUtil = jwtUtil;
	}
	
	//댓글 추가
	@PostMapping("/comments")
	public ResponseEntity<?> writeComment(@RequestBody Comment comment, @RequestHeader("Authorization") String token) {
		try {
			//1. "Bearer<토큰>"에서 실제 토큰 부분만 추출
			String actualToken = token.replace("Bearer", "");
			
			//2. 추출한 토큰 사용해 사용자 정보 가져옴
			//jwtUtil은 jwt토큰을 분석해서 사용자 정보를 추출하는 도구
			Integer userNo = jwtUtil.getUserNo(actualToken); //사용자 번호 가져오기
			String userId = jwtUtil.getUserId(actualToken); //사용자 아이디 가져오기
		
			//3. 가져온 사용자 정보를 댓글 객체에 추가
			//이렇게 하면 댓글 작성자가 누구인지 저장할 수 있음
			comment.setUserId(userId);
			
			//4. 댓글 작성 로직을 서비스에 전달
			boolean isAdded = commentService.writeComment(comment);
			
			  // 5. 댓글 작성 성공 여부에 따라 응답 반환
			if(isAdded) {
				// 댓글이 정상적으로 추가되었을 경우, HTTP 상태 코드 201(CREATED) 반환
				return ResponseEntity.status(HttpStatus.CREATED).build();
			}
			// 댓글 작성에 실패한 경우, 서버 에러 상태 코드 반환
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		} catch (Exception e) {
			// 예외가 발생했을 경우, 에러 메시지와 함께 서버 에러 상태 코드 반환
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("에러: " + e.getMessage());
			
		}
		
	}
	
	
	
	//댓글 삭제
	
	
	
	
	//댓글 신고
	
	
	
	
}
