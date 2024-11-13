package com.ssafy.soda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.User;
import com.ssafy.soda.model.service.AdminBoardService;
import com.ssafy.soda.model.service.AdminUserService;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	AdminBoardService adminBoardService;
	public BoardController(AdminBoardService adminBoardService) {
		this.adminBoardService = adminBoardService;
	}

	
	// user 모두 조회하기
	@GetMapping("/adminBoard")
	public String adminBoard(Model model) {
		List<Board> list = adminBoardService.getBoardlist();
//		System.out.println(list);
		
		model.addAttribute("list", list);
		return "board/adminBoard";
	}
	
	@GetMapping("/adminBoardDetail")
	public String adminBoardDetail(@RequestParam("no") int no, Model model) {
	Board board = adminBoardService.getBoard(no);
	if(board.getUser() != null) {
		String userId = board.getUser().getUserId();		
		model.addAttribute("userId", userId);
	}else {
		model.addAttribute("userId", "*** 삭제된 유저입니다. ***");		
	}
	model.addAttribute("board", board);
	return "/board/adminBoardDetail";
}
	
	
}
