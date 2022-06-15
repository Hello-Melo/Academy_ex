package com.hoon.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoon.model.Board;
import com.hoon.model.Member;
import com.hoon.service.BoardService;
import com.hoon.service.MemberService;
import com.hoon.validation.MemberValidator;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/success")
	public String success() {
		return "member/success";
	}
	
	@GetMapping("/list")
	public String findAll(Model model) {
		List<Member> list = service.findAll();
		model.addAttribute("list", list);
		return "member/list";
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
		}else {
			service.insert(member);
			}
		return "redirect:/";
	}

	@GetMapping("/get")
	public String findByid(Long id, Model model) {
		Member member = service.findById(id);
		model.addAttribute("member", member);
		return "member/get";
	}
	
	@PostMapping("/remove")
	public String delete(Long id) {
		service.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updateForm() {
		return "member/update";
	}
	
	@PostMapping("/update")
	public String update(Member member) {
		service.update(member);
		return "redirect:/";
	}
	
	
	
}
