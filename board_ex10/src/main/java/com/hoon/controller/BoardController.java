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
import com.hoon.model.Criteria;
import com.hoon.model.PageMaker;
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
	public String getList(Criteria criteria, Model model) {
		PageMaker maker = new PageMaker(criteria, service.totalCoutnt(criteria));
		
		List<Board> list = service.getList(criteria);
		model.addAttribute("pageMaker", maker);
		model.addAttribute("list", list);
		return "board/list";
	}

	@GetMapping("/register")
	public String registerForm(Board board, Model model) {
		return "board/register";
	}

	@PostMapping("/register")
	public String register(Board board, Errors errors, RedirectAttributes rtts) {
		service.insert(board);
		new BoardValidatior().validate(board, errors);
			if (errors.hasErrors()) {
				return "board/register";
			}
		return "redirect:/list";
	}
	
	@GetMapping("/get")
	public String get(Long bno, Model model) {
		model.addAttribute("board", service.findByBno(bno));
		return "board/get";
	}
	
	@GetMapping("/update")
	public String updateForm() {
		return "board/update";
	}
	
	@PostMapping("/update")
	public String update(Board board, RedirectAttributes rtts) {
		service.update(board);
		return "redirect:/board/list";
	}
	
}
