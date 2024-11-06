package com.ssafy.soda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.soda.model.dto.User;
import com.ssafy.soda.model.service.AdminUserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	//서비스 싱글턴 주입
	private AdminUserService adminUserService;

	public AdminController(AdminUserService adminUserService) {
		super();
		this.adminUserService = adminUserService;
	}
	//첫 화면은 로그인화면으로 이동
	@GetMapping("/main")
	public String adminMain() {
	System.out.println("확인");
		return "admin/adminLogin";
	}
	
	//사용자 전체목록 이동
	@GetMapping("/adminUserBoard")
	public String list(Model model) {
		List<User> users = adminUserService.getAllUser();
		model.addAttribute("users", users);
		return "admin/adminUserBoard";
	}
	
	//사용자 상세보기
	@GetMapping("/adminUserDetail")
	public String detail(@RequestParam("id")int id, Model model) {
		adminUserService.detailUser(id);
		return "admin/adminUserDetail";
		
	}
	
	//사용자 삭제
	@DeleteMapping("/adminUserBoard")
	public String delete(@RequestParam("id") int id) {
		adminUserService.removeUser(id);
		return "redirectadmin/adminUserBoard";
	}
	
	//로그인 화면으로 넘어가기
	@GetMapping("adminLogin")
	public String loginform() {
		return "admin/adminLogin";
	}
	
	//로그인하기
	@PostMapping("adminLogin")
	public String login(@RequestParam("userId") String userId, @RequestParam("password") String password,
		Model model) {
		if("admin".equals(userId) && "admin".equals(password)) {
			return "redirect:/admin/adminMain";
		} else {
			model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
			return "/admin/adminLogin";
		}
	}
	
	//로그아웃
	
	
	
	
	
	
	//신고된 사용자 조회
	
	
	
	
	
	
	
	
}
