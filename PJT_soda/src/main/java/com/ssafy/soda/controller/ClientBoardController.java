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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.soda.jwt.JwtUtil;
import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.Likes;
import com.ssafy.soda.model.service.AdminBoardService;
import com.ssafy.soda.model.service.ImageService;

@RestController
@RequestMapping("/etco/board")
public class ClientBoardController {

	private final AdminBoardService adminBoardService;
	private final ImageService imageService;

	private final JwtUtil jwtUtil;

	public ClientBoardController(AdminBoardService adminBoardService, JwtUtil jwtUtil, ImageService imageService) {
		this.adminBoardService = adminBoardService;
		this.jwtUtil = jwtUtil;
		this.imageService = imageService;
	}

	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Board>> list() {
		List<Board> list = adminBoardService.getBoardlist();
//		System.out.println(list);
		if (list != null) {
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// 상세 조회
	@GetMapping("/{no}")
	public ResponseEntity<Board> detail(@PathVariable("no") int no) {

		adminBoardService.increaseViewCnt(no);
		Board board = adminBoardService.getBoard(no);
		
		if (board != null) {
			System.out.println("보드 디테일 들고감!:" + board);
			return ResponseEntity.ok(board);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("")
	public ResponseEntity<?> write(@RequestBody Board board, 
	                             @RequestHeader("Authorization") String token) {
	    try {
	        // 기존 토큰 처리 & 사용자 정보 설정
	        String actualToken = token.replace("Bearer ", "");
	        Integer userNo = jwtUtil.getUserNo(actualToken);
	        String userId = jwtUtil.extractUserName(actualToken);
	        board.setUserNo(userNo);
	        board.setWriter(userId);
	        System.out.println("write메서드에서 토큰에서 추출한 userNo:" + userNo);

	        // 1. 게시글 저장
	        boolean isAdded = adminBoardService.writeBoard(board);
	        
	        // 2. 임시 이미지들 연결 (board.getImageIds()가 있다고 가정)
	        if(isAdded && board.getImageIds() != null) {
	            imageService.updateBoardNo(board.getBoardNo(), board.getImageIds());
	        }

	        return isAdded ? 
	            ResponseEntity.ok("Board added") : 
	            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Board");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }

	}
	
	//삭제 
	@DeleteMapping("/{no}")
	public ResponseEntity<?> delete(@PathVariable("no") int no, @RequestHeader("Authorization") String token) { // 프론트의 인터셉터가 보낸 헤더를 여기서 받음
		try {
			System.out.println("delete메서드 진입");
			//1. "Bearer xxxx" 형태에서 실제 토큰만 추출
			String actualToken = token.replace("Bearer ", "");
			
			//2. 토큰에서 사용자 번호 가져오기
			Integer userNo = jwtUtil.getUserNo(actualToken);
			System.out.println("delete메서드 사용자 번호:" + userNo);
			//3. 게시글 정보 가져오기
			Board board = adminBoardService.getBoard(no);
			System.out.println("delete메서드 보드:" + board);
			
			//4. 게시글 존재 여부 체크
			if(board ==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("게시글을 찾을 수 없습니다.");
			}
			
			//5. 작성자 본인인지 체크
//			if(!userNo.equals(board.getUserNo())) {
//				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("삭제 권한이 없습니다.");
//			}
			
			boolean isDeleted = adminBoardService.deleteBoard(no);
			System.out.println("isDeleted:" + isDeleted);
			if(isDeleted) {
				return ResponseEntity.status(HttpStatus.OK).body("Board deleted");
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Board");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error" + e.getMessage());
		}
	}

	// 수정 (유저가 같다면)
	// 수정 메서드 수정
	@PutMapping("/{no}")
	public ResponseEntity<?> update(@PathVariable("no") int no, @RequestBody Board board,
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
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("게시글을 찾을 수 없습니다.");
			}

			// 작성자와 현재 사용자가 다른 경우
			if (!userNo.equals(existingBoard.getUserNo())) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("수정 권한이 없습니다.");
			}

			// 게시글 번호 설정
			board.setBoardNo(no);
			board.setUserNo(userNo); // 현재 사용자 번호 설정

			// 수정 실행
			boolean isUpdated = adminBoardService.updateBoard(board);
			if (isUpdated) {
				return ResponseEntity.ok("Board updated");
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update Board");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
		}
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<Board>> catagory(@PathVariable("category") String category,
			@RequestParam(value = "detailCategory", required = false) String detailCategory, Board board) {
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
	
	@PostMapping("/like/{no}")
	public ResponseEntity<?> likeAdd(@PathVariable("no") int boardNo, @RequestHeader("Authorization") String token) {
		Likes likes = new Likes();
		System.out.println("받아온 likes:" + likes);
		try {
	            // Bearer 토큰에서 실제 토큰 추출
	            String actualToken = token.replace("Bearer ", "");
	            
	            // 토큰에서 userNo 추출
	            Integer userNo = jwtUtil.getUserNo(actualToken);
	            
	            likes.setBoardNo(boardNo);
	            likes.setUserNo(userNo);
	            
	           boolean addedLike = adminBoardService.addLike(likes);
	            
	           if(addedLike) {
	        	   return ResponseEntity.ok("like added");
	           }else {
	        	   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                       .body("Failed to add like");
	           }
	            
		 }catch(Exception e){
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		                .body("Error: " + e.getMessage());
		 }
	}
	
	
	
}
