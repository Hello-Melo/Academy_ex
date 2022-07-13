package com.hoon.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.graalvm.compiler.lir.BailoutAndRestartBackendException_OptionDescriptors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hoon.model.Board;

@Controller
public class HomeController {

	
	@GetMapping("/")
	public String home(HttpServletResponse response) {
		//쿠키 생성. 서블렛 response로 쿠키를 보내는것! 
		List<Board> boardList = new ArrayList<Board>();
				
		Cookie cookie = new Cookie("myCookie", "초코쿠키");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
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
