package com.ssafy.soda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.User;
import com.ssafy.soda.model.service.AdminBoardService;
import com.ssafy.soda.model.service.AdminUserService;

import jakarta.servlet.http.HttpSession;

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
	
//	//게시판 상세보기
//	@GetMapping("/adminUserDetail")
//	public String detail(@RequestParam("no") int no, Model model) {
//		User user = adminUserService.detailUser(no);
//		model.addAttribute("user", user);
//		return "admin/adminUserDetail";
//		
//	}
//	
//	//게시판 삭제
//	@GetMapping("/adminUserDelete")
//	public String delete(@RequestParam("no") int no) {
//		adminUserService.removeUser(no);
//		return "redirect:/admin/adminUserBoard";
//	} 
//	
//	//게시판 수정폼 이동
//	@GetMapping("/adminUserUpdateForm")
//	public String updateform(@RequestParam("no")int no, Model model) {
//		User user = adminUserService.detailUser(no);
//		model.addAttribute("user", user);
//		System.out.println("수정폼"+ user);
//		return "admin/adminUserUpdateForm";
//	}
//	
//	//사용자 수정
//	@PostMapping("/adminUserUpdate")
//	public String update(User user) {
//		System.out.println("수정"+user);
//		adminUserService.modifyUser(user); // id 뿐만 아니라 수정된 사용자 정보 전체를 전달
//		return "redirect:/admin/adminUserDetail?no=" + user.getUserNo();
//	}

	//아이디, 이름, 이메일 로 검색하기
	
	
	//신고된 사용자 조회

	
}
