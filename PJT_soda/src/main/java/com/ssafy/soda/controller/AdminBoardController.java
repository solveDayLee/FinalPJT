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

@Controller
@RequestMapping("/admin")
public class AdminBoardController {
	
	//서비스 싱글턴 주입
	private AdminBoardService adminBoardService;

	public AdminBoardController(AdminBoardService adminBoardService) {
		super();
		this.adminBoardService = adminBoardService;
	}
	
	//게시판 전체목록 이동
	@GetMapping("/adminBoard")
	public String list(Model model) {
		List<Board> board = adminBoardService.getAllBoard();
		model.addAttribute("list", board);
		return "admin/adminBoard";
	}
	
	//게시판 상세보기
	@GetMapping("/adminBoardDetail")
	public String detail(@RequestParam("no") int no, Model model) {
		User user = adminBoardService.detailBoard(no);
		model.addAttribute("user", user);
		return "admin/adminBoardDetail";
		
	}
	
	//게시판 삭제
	@GetMapping("/adminUserDelete")
	public String delete(@RequestParam("no") int no) {
		adminBoardService.removeBoard(no);
		return "redirect:/admin/adminBoard";
	} 
	
	//아이디, 이름, 이메일 로 검색하기
	
	
	//신고된 사용자 조회

	
}