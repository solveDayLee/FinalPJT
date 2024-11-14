package com.ssafy.soda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.SearchCondition;
import com.ssafy.soda.model.service.AdminBoardService;


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
		List<Integer> likes = adminBoardService.likesListCount();
		
		model.addAttribute("list", list);
		model.addAttribute("likes", likes);
		return "board/adminBoard";
	}
	
	@GetMapping("/adminBoardDetail")
	public String adminBoardDetail(@RequestParam("no") int no, Model model) {
	Board board = adminBoardService.getBoard(no);
	
	int likesCount = adminBoardService.getLikesCount(no);
	
	if(board.getUser() != null) {
		String userId = board.getUser().getUserId();		
		model.addAttribute("userId", userId);
	}else {
		model.addAttribute("userId", "*** 삭제된 유저입니다. ***");		
	}
	model.addAttribute("board", board);
	model.addAttribute("likesCount", likesCount);
	return "/board/adminBoardDetail";
}
	
	// user 삭제하기
	@GetMapping("/adminBoardDelete")
	public String adminBoardDelete(@RequestParam("no") int no) {
		adminBoardService.deleteBoard(no);
		System.out.println("삭제 메서드 실행");
		return "redirect:/board/adminBoard";
	}
	
	// 검색해서 리스트 나오게 하기 
	@GetMapping("/searchAdminBoard")
	public String searchAdminUserBoard(SearchCondition searchCondition, Model model) {
//		System.out.println("파라미터 잘 받아왔나: " + searchCondition);
		List<Board> list = adminBoardService.getSearchedBoardlist(searchCondition);
		model.addAttribute("list", list);
//		System.out.println("검색된 리스트!:" + list);
		return "board/adminBoard";
	}
	
	
}
