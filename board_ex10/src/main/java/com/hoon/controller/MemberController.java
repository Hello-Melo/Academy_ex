package com.hoon.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoon.model.Member;
import com.hoon.validation.MemberValidator;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	
	@GetMapping("/success")
	public String success() {
		return "member/success";
	}
	
	@GetMapping("/register")
	public String registerForm(Member member, Errors errors) {
	
		return "member/register";
	}

	@PostMapping("/register")
	public String register(@Valid Member member, Errors errors ) {
		new MemberValidator().validate(member, errors);
		if(errors.hasErrors()) {
			
			return "member/register";
		}
		return "redirect:success";
	}
	
}
