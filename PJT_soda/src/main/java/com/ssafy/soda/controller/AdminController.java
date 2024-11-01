package com.ssafy.soda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/main")
	public String adminMain() {
	System.out.println("확인");
		return "admin/adminMain";
	}
	
}
