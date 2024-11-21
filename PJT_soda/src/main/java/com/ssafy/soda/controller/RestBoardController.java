package com.ssafy.soda.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.service.AdminBoardService;

@RestController
@RequestMapping("/etco")
public class RestBoardController {
	
	private final AdminBoardService adminBoardService;

	public RestBoardController(AdminBoardService adminBoardService) {
		super();
		this.adminBoardService = adminBoardService;
	}
	//전체조회
	@GetMapping("/board")
	public ResponseEntity<List<Board>> list() {
		List<Board> list = adminBoardService.getBoardlist();
		System.out.println(list);
		return ResponseEntity.ok(list);
		
	}
	//상세조회
	@GetMapping("/board/{no}")
	public ResponseEntity<Board> detail(@PathVariable("no") int no) {
		Board board = adminBoardService.getBoard(no);
		System.out.println(board);
		if(board != null) {
			return ResponseEntity.ok(board);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	//추가
	@PostMapping("/board")
	public ResponseEntity<?> write(@RequestBody Board board){
		adminBoardService.writeBoard(board);
		System.out.println(board);
		System.out.println(board.getUserNo());
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	
	
	//삭제
	@DeleteMapping("/board/{no}")
	public ResponseEntity<String> delete(@PathVariable("no") int no) {
		boolean isDeleted = adminBoardService.deleteBoard(no);
		if(isDeleted) {
			return ResponseEntity.status(HttpStatus.OK).body("Board delete");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	}
	
	//수정
	@PutMapping("/board/{no}")
	public ResponseEntity<Void> update(@PathVariable("no") int no, @RequestBody Board board) {
		board.setBoardNo(no);
		adminBoardService.updateBoard(board);
		System.out.println(board);
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
