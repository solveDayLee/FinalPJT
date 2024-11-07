package com.ssafy.soda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.soda.model.dto.User;
import com.ssafy.soda.model.service.AdminUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	AdminUserService adminUserService;
	public AdminController(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	@GetMapping("/main")
	public String adminMain() {
		return "admin/adminMain";
	}

	// user 모두 조회하기
	@GetMapping("/adminUserBoard")
	public String adminUserBoard(Model model) {
		List<User> list = adminUserService.getUserlist();
//		System.out.println(list);
		model.addAttribute("list", list);
		return "admin/adminUserBoard";
	}
	@GetMapping("/adminUserDetail")
		public String adminUserBoardDetail(@RequestParam("id") String id, Model model) {
		User user = adminUserService.getUser(id);
		System.out.println(user);
		model.addAttribute("user", user);
		return "/admin/adminUserDetail";
	}
	@GetMapping("/adminUserUpdateForm")
	public String adminUserUpdate(@RequestParam("id") String id, Model model) {
		User user = adminUserService.getUser(id);
		model.addAttribute("user", user);
		return "/admin/adminUserUpdateForm";
	}
	
//	@GetMapping("/adminUserUpdate")
//	public String adminUserUpdate(@RequestParam("user") User user, Model model) {
//		// user 디테일로 가려면 id 저장해둬야 함. 
//		User user = adminUserService.getUser(id);
//		model.addAttribute("user", user);
//		return "/admin/adminUserUpdate";
//	}
	

	// 로그인 화면으로 넘어가기
	@GetMapping("/adminLogin")
	public String adminLogin() {
		return "admin/adminLogin";
	}

	// 로그인하기
	@PostMapping("/login")
	public String adminLogin(User user) {
		System.out.println("로그인 이름: " + user.getUserId());
		System.out.println("로그인 비번: " + user.getPassword());
		
		if (("admin").equals(user.getUserId()) && ("admin").equals(user.getPassword())) {
			return "admin/adminMain";
		} else {
			return "admin/adminLogin";
		}
	}

	// user id/ 이름으로 검색하기

	// user 정보 수정하기

	// user 삭제하기

	// user 중 신고된 유저만 조회하기

}
