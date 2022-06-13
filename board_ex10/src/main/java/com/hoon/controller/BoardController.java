package com.hoon.controller;

import java.util.List;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hoon.model.Board;
import com.hoon.service.BoardService;
import com.hoon.service.BoardServiceImpl;
import com.hoon.validation.BoardValidatior;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	BoardServiceImpl service;

	Board board = new Board();
	
	@GetMapping("/list")
	public String getList(Model model) {
		List<Board> list = service.getList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@GetMapping("/register")
	public String registerForm(Board board, Model model) {
		
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register(Board board, Errors errors, RedirectAttributes rtts) {
		new BoardValidatior().validate(board, errors);
		if(errors.hasErrors()) {
			
			return "board/register";
		}
		
		
		System.out.println("제목 : " + board.getTitle());
		System.out.println("내용 : " + board.getContents());
		System.out.println("작성자 : " + board.getWriter());
		
		return "redirect:/";
	}
}
