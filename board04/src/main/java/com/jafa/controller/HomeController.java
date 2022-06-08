package com.jafa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jafa.dto.Member;

@Controller
public class HomeController {
	
	@GetMapping("/")
		public String home(){
		return "welcome";
	}

	@GetMapping("/member/list")
	public String memberList(@RequestParam(value="id", defaultValue = "킹본값") String id) {
		System.out.println(id);
		return "memberList";
	}
	
	@GetMapping("/member/join")
	public String joinForm() {
		return "join";
	}
	
	@PostMapping("/member/join")
	public String join(Member member) {
		System.out.println(member.getId());
		System.out.println(member.getEmail());
		System.out.println(member.getPw());
		return "redirect:/";
		
	}	
}
