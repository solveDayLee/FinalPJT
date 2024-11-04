package com.ssafy.soda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.soda.model.dto.User;
import com.ssafy.soda.model.service.AdminUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	//서비스 싱글턴 주입
	private AdminUserService adminUserService;

	public AdminController(AdminUserService adminUserService) {
		super();
		this.adminUserService = adminUserService;
	}
	//메인 화면 이동
	@GetMapping("/main")
	public String adminMain() {
	System.out.println("확인");
		return "admin/adminMain";
	}
	
	//사용자 전체목록 이동
	@GetMapping("/adminUserBoard")
	public String list(Model model) {
		List<User> users = adminUserService.getAllUser();
		model.addAttribute("users", users);
		return "adminUserBoard";
	}
	
	//사용자 상세보기
	@GetMapping("/adminUserDetail")
	public String detail(@RequestParam("id")int id, Model model) {
		return "adminUserDetail";
		
	}
	
	//사용자 삭제
	@GetMapping("/adminUserBoard")
	public String delete(@RequestParam("id") int id) {
		return "adminUserBoard";
	}
	
	//로그인하기
	
	//신고된 사용자 조회
	
	
	
	
	
	
	
	
}
