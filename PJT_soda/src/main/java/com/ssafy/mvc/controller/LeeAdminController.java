package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LeeAdminController {
	
	@GetMapping("main")
	public String adminMain() {
		
		return "admin/adminMain";
	}
	
}
