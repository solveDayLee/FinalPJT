package com.ssafy.soda.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.service.AdminBoardService;
import org.springframework.web.bind.annotation.RequestParam;





@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/etco/board")
public class ClientBoardController {
	
	AdminBoardService adminBoardService;
	public ClientBoardController(AdminBoardService adminBoardService) {
		this.adminBoardService = adminBoardService;
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
		System.out.println("보드 디테일 들고감!");
		Board board = adminBoardService.getBoard(no);
		if (board != null) {
			return ResponseEntity.ok(board);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	//추가 
	@PostMapping("")
	public ResponseEntity<?> write(/* @ModelAttribute */ @RequestBody Board board) {
		System.out.println(board + " 추가할 보드임. ");
		boolean isAdded = adminBoardService.writeBoard(board);
		System.out.println("isAdded" + isAdded);
		if(isAdded) {
			return ResponseEntity.status(HttpStatus.OK).body("Board added");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Board");	
	}
	
	
	//삭제 
	@DeleteMapping("/{no}")
	public ResponseEntity<?> delete(@PathVariable("no") int no) {
		boolean isDeleted = adminBoardService.deleteBoard(no);
		if(isDeleted) {
			return ResponseEntity.status(HttpStatus.OK).body("Board deleted");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Board");	
	}
	
	//수정 (유저가 같다면)
	@PutMapping("/{no}")
	public ResponseEntity<?> update(@PathVariable("no") int no, @RequestBody Board board) {
		board.setBoardNo(no);
		boolean isUpdated = adminBoardService.updateBoard(board);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK).body("Board updated");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update Board");	
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
	

}
