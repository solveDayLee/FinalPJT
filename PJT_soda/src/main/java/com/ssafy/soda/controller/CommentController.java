package com.ssafy.soda.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.soda.jwt.JwtUtil;
import com.ssafy.soda.model.dto.Comment;
import com.ssafy.soda.model.service.CommentService;

@RestController
@RequestMapping("/etco")
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
	@DeleteMapping("/comments/{commentNo}")
	public ResponseEntity<?> delete(@PathVariable("commentNo") int commentNo, 
			@RequestHeader("Authorization") String token){
		try {
			String actualToken = token.replace("Bearer ", "");
			String userId = jwtUtil.getUserId(actualToken);
			
			//삭제하려는 댓글 정보 가져오기
			Comment comment = commentService.getComment(commentNo);
			
			if(comment == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("삭제할 댓글이 없음");
			}
			
			if(!userId.equals(comment.getUserId())) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("삭제권한 없음");
			}
			
			//댓글 삭제 실행
			boolean isDeleted = commentService.deleteComment(commentNo);
			if(isDeleted) {
				return ResponseEntity.ok("댓글이 삭제되었습니다");
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 삭제 실패");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("에러: " + e.getMessage());
		}
	}
	
	
	
	//댓글 수정
	@PutMapping("/comments/{commentNo}")
	public ResponseEntity<?> updateComment(
	    @PathVariable("commentNo") int commentNo,
	    @RequestBody Comment comment,
	    @RequestHeader("Authorization") String token
	) {
	    try {
	        // 1. 토큰에서 사용자 ID 추출
	        String actualToken = token.replace("Bearer ", "");
	        String userId = jwtUtil.getUserId(actualToken); // 사용자 ID 가져오기
	        
	        // 2. 수정하려는 댓글 정보 가져오기
	        Comment existingComment = commentService.getComment(commentNo);
	        
	        // 3. 댓글 존재 여부 확인
	        if (existingComment == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("수정할 댓글을 찾을 수 없습니다.");
	        }
	        
	        // 4. 댓글 작성자와 현재 사용자 ID 비교
	        if (!userId.equals(existingComment.getUserId())) { // 작성자가 아닌 경우
	            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("수정 권한이 없습니다.");
	        }
	        
	        // 5. 댓글 수정 내용 설정
	        comment.setCommentNo(commentNo); // 댓글 번호 설정
	        comment.setUserId(userId); // 현재 사용자 ID 설정
	        
	        // 6. 댓글 수정 실행
	        boolean isUpdated = commentService.updateComment(comment);
	        if (isUpdated) {
	            return ResponseEntity.ok("댓글이 성공적으로 수정되었습니다.");
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 수정에 실패했습니다.");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("에러: " + e.getMessage());
	    }
	}


	//댓글 신고
	
	
	
	
}
