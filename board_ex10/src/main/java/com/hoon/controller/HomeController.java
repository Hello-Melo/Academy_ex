package com.hoon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("/")
	public String home() {
		return "Welcome";
	}
	
	@GetMapping("/admin/list")
	public String admin() {
		System.out.println("컨트롤러 실행  :  Admin");
		return "admin";
	}
	
	@GetMapping("/admin/aa")
	public String aa() {
		System.out.println("컨트롤러 실행  : aa");
		return "aa";
		
	}
	
}
