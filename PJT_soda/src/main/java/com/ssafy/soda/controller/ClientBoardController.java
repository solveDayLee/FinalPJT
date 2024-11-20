package com.ssafy.soda.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.service.AdminBoardService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/etco")
public class ClientBoardController {
	
	AdminBoardService adminBoardService;
	public ClientBoardController(AdminBoardService adminBoardService) {
		this.adminBoardService = adminBoardService;
	}
	
	//전체 조회
	@GetMapping("/board")
	public ResponseEntity<List<Board>> list() {
		List<Board> list = adminBoardService.getBoardlist();
//		System.out.println(list);
		if (list != null) {
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	//상세 조회
	@GetMapping("/board/{no}")
	public ResponseEntity<Board> detail(@PathVariable("no") int no) {
		Board board = adminBoardService.getBoard(no);
		if (board != null) {
			return ResponseEntity.ok(board);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	//추가 
	@PostMapping("/board")
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
	@DeleteMapping("/board/{no}")
	public ResponseEntity<?> delete(@PathVariable("no") int no) {
		boolean isDeleted = adminBoardService.deleteBoard(no);
		if(isDeleted) {
			return ResponseEntity.status(HttpStatus.OK).body("Board deleted");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Board");	
	}
	
	//수정 (유저가 같다면)
	@PutMapping("/board/{no}")
	public ResponseEntity<?> update(@PathVariable("no") int no, @RequestBody Board board) {
		board.setBoardNo(no);
		boolean isUpdated = adminBoardService.updateBoard(board);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK).body("Board updated");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update Board");	
	}

}
