package com.ssafy.soda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.soda.model.dto.SearchCondition;
import com.ssafy.soda.model.dto.User;
import com.ssafy.soda.model.service.AdminUserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
	
	//서비스 싱글턴 주입
	private AdminUserService adminUserService;

	public AdminUserController(AdminUserService adminUserService) {
		super();
		this.adminUserService = adminUserService;
	}
	//첫 화면은 로그인화면으로 이동
	@GetMapping("/main")
	public String adminMain() {
//	System.out.println("확인");
		return "admin/adminLogin";
	}
	
	//사용자 전체목록 이동
	@GetMapping("/adminUserBoard")
	public String list(Model model) {
		List<User> users = adminUserService.getAllUser();
		model.addAttribute("list", users);
		return "admin/adminUserBoard";
	}
	
	//사용자 상세보기
	@GetMapping("/adminUserDetail")
	public String detail(@RequestParam("no") int no, Model model) {
		User user = adminUserService.detailUser(no);
		model.addAttribute("user", user);
		return "admin/adminUserDetail";
		
	}
	
	//사용자 삭제
	@GetMapping("/adminUserDelete")
	public String delete(@RequestParam("no") int no) {
		adminUserService.removeUser(no);
		return "redirect:/admin/adminUserBoard";
	}
	
	//사용자 수정폼 이동
	@GetMapping("/adminUserUpdateForm")
	public String updateform(@RequestParam("no")int no, Model model) {
		User user = adminUserService.detailUser(no);
		model.addAttribute("user", user);
		System.out.println("수정폼"+ user);
		return "admin/adminUserUpdateForm";
	}
	
	//사용자 수정
	@PostMapping("/adminUserUpdate")
	public String update(User user) {
		System.out.println("수정"+user);
		adminUserService.modifyUser(user); // id 뿐만 아니라 수정된 사용자 정보 전체를 전달
		return "redirect:/admin/adminUserDetail?no=" + user.getUserNo();
	}
	
	
	
	//로그인 화면으로 넘어가기
	@GetMapping("adminLogin")
	public String loginform() {
		return "admin/adminLogin";
	}
	
	//로그인하기
	@PostMapping("adminLogin")
	public String login(@RequestParam("userId") String userId, @RequestParam("password") String password,
		Model model, HttpSession session) {
		if("admin".equals(userId) && "admin".equals(password)) {
			session.setAttribute("adminId", userId);
			return "redirect:/admin/adminMain";
		} else {
			model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
			return "/admin/adminLogin";
		}
	}
	
	//로그아웃
	@PostMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/adminMain";
	}

	@GetMapping("/adminMain")
	public String mainPage() {
		return "/admin/adminMain";
	}
	
	//아이디, 이름, 이메일 로 검색하기
	@GetMapping("/searchAdminBoard")
	public void searchAdminBoard(SearchCondition searchCondition, Model model) {
		
		


		}
	}	
	
	
	
	
	//신고된 사용자 조회
	
	
	
	
	
	
	
	
}
