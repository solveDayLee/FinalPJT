package com.ssafy.soda.controller;

import java.util.List;

import javax.xml.stream.events.Comment;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.soda.jwt.JwtUtil;
import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.service.AdminBoardService;

@RestController
@RequestMapping("/etco/board")
public class ClientBoardController {
	
	private final AdminBoardService adminBoardService;
	private final JwtUtil jwtUtil;
	public ClientBoardController(AdminBoardService adminBoardService, JwtUtil jwtUtil) {
		this.adminBoardService = adminBoardService;
		this.jwtUtil = jwtUtil;
	}
	
	//전체 조회
	@GetMapping("")
	public ResponseEntity<List<Board>> list() {
		List<Board> list = adminBoardService.getBoardlist();
//		System.out.println(list);
		if (list != null) {
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	//상세 조회
	@GetMapping("/{no}")
	public ResponseEntity<Board> detail(@PathVariable("no") int no) {
		Board board = adminBoardService.getBoard(no);
		if (board != null) {
			System.out.println("보드 디테일 들고감!:" + board);
			return ResponseEntity.ok(board);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	//추가 
	@PostMapping("")
	public ResponseEntity<?> write(/* @ModelAttribute */ @RequestBody Board board, @RequestHeader("Authorization") String token) {
		
		try {
			System.out.println(board + " 추가할 보드임. ");
			
			 // 토큰에서 사용자 정보 추출
	        String actualToken = token.replace("Bearer ", "");
	        Integer userNo = jwtUtil.getUserNo(actualToken);
	        String userId = jwtUtil.getUserId(actualToken); // JwtUtil에 getUserId 메서드가 필요합니다
	        
	        // 게시글에 작성자 정보 설정
	        board.setUserNo(userNo);
	        board.setWriter(userId);
			
			
			
			
			boolean isAdded = adminBoardService.writeBoard(board);
			System.out.println("isAdded" + isAdded);
			if(isAdded) {
				return ResponseEntity.status(HttpStatus.OK).body("Board added");
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Board");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
		}
		
	}
	
	//삭제 
	@DeleteMapping("/{no}")
	public ResponseEntity<?> delete(@PathVariable("no") int no, @RequestHeader("Authorization") String token) { // 프론트의 인터셉터가 보낸 헤더를 여기서 받음
		try {
			//1. "Bearer xxxx" 형태에서 실제 토큰만 추출
			String actualToken = token.replace("Bearer ", "");
			
			//2. 토큰에서 사용자 번호 가져오기
			Integer userNo = jwtUtil.getUserNo(actualToken);
			
			//3. 게시글 정보 가져오기
			Board board = adminBoardService.getBoard(no);
			
			//4. 게시글 존재 여부 체크
			if(board ==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("게시글을 찾을 수 없습니다.");
			}
			
			//5. 작성자 본인인지 체크
			if(!userNo.equals(board.getUserNo())) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("삭제 권한이 없습니다.");
			}
			
			boolean isDeleted = adminBoardService.deleteBoard(no);
			if(isDeleted) {
				return ResponseEntity.status(HttpStatus.OK).body("Board deleted");
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Board");	
		
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error" + e.getMessage());
		}
	}
	
	//수정 (유저가 같다면)
	// 수정 메서드 수정
    @PutMapping("/{no}")
    public ResponseEntity<?> update(@PathVariable("no") int no,
                                  @RequestBody Board board,
                                  @RequestHeader("Authorization") String token) {
        try {
            // Bearer 토큰에서 실제 토큰 추출
            String actualToken = token.replace("Bearer ", "");
            
            // 토큰에서 userNo 추출
            Integer userNo = jwtUtil.getUserNo(actualToken);
            
            // 기존 게시글 조회
            Board existingBoard = adminBoardService.getBoard(no);
            
            // 게시글이 존재하지 않는 경우
            if (existingBoard == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("게시글을 찾을 수 없습니다.");
            }
            
            // 작성자와 현재 사용자가 다른 경우
            if (!userNo.equals(existingBoard.getUserNo())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("수정 권한이 없습니다.");
            }
            
            // 게시글 번호 설정
            board.setBoardNo(no);
            board.setUserNo(userNo);  // 현재 사용자 번호 설정
            
            // 수정 실행
            boolean isUpdated = adminBoardService.updateBoard(board);
            if (isUpdated) {
                return ResponseEntity.ok("Board updated");
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to update Board");
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error: " + e.getMessage());
        }
    }

	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Board>> catagory(@PathVariable("category") String category, @RequestParam(value = "detailCategory", required = false) String detailCategory, Board board) {
		System.out.println("컨트롤러에서 카테고리 검색 메서드 실행!");
		board.setCategory(category);
		if (detailCategory != null) {
			board.setDetailCategory(detailCategory);			
		}
		
		System.out.println("검색으로 쓰일 보드: " + board);
		
		List<Board> list = adminBoardService.getBoardlistByCatagory(board);
		if (list != null) {
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	//댓글 추가
//	@PostMapping("/comments")
//	public ResponseEntity<?> writeComment(@RequestBody Comment commnet, @RequestHeader("Authorization") String token) {
//		
//	}
	
	
	
	//댓글 삭제
	
	
	
	
	//댓글 신고
	
	
	
	
}
