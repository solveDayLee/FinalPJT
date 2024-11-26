package com.ssafy.soda.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/comments/{boardNo}")
	public ResponseEntity<?> getComments(
	    @PathVariable("boardNo") int boardNo,
	    @RequestHeader("Authorization") String token
	) {
	    try {
	        // "Bearer " 부분을 제거하고 토큰만 추출
	        String actualToken = token.replace("Bearer ", "");
	        
	        // 토큰 유효성 검증 및 사용자 정보 추출
	        String userId = jwtUtil.getUserId(actualToken);
	        
	        // 댓글 목록 조회
	        List<Comment> comments = commentService.getComments(boardNo);
	        
	        return ResponseEntity.ok(comments);
	    } catch (Exception e) {
	        // 에러 로깅 추가
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                           .body("댓글 조회 실패: " + e.getMessage());
	    }
	}
	
	
	//댓글 추가
	@PostMapping("/comments")
	public ResponseEntity<?> writeComment(
	    @RequestBody Comment comment, 
	    @RequestHeader("Authorization") String token
	) {
	    try {
	        // 토큰 검증
	        String actualToken = token.replace("Bearer ", "");
	        String userId = jwtUtil.getUserId(actualToken);
	        
	        // 필수 데이터 검증
	        if (comment.getBoardNo() <= 0) {
	            return ResponseEntity.badRequest().body("게시글 번호가 유효하지 않습니다.");
	        }
	        if (comment.getComment() == null || comment.getComment().trim().isEmpty()) {
	            return ResponseEntity.badRequest().body("댓글 내용을 입력해주세요.");
	        }
	        
	        // 사용자 ID 설정
	        comment.setUserId(userId);
	        
	        // 댓글 저장
	        Comment savedComment = commentService.writeComment(comment);
	        if (savedComment != null) {
	            return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                               .body("댓글 저장에 실패했습니다.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // 로깅
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                           .body("서버 오류: " + e.getMessage());
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
