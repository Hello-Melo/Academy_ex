package com.jafa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.model.Board;
import com.jafa.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public String getBoardList(Model model) {
		
		List<Board> list = service.getList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@GetMapping("/get")
	public String get(Long bno, Model model) {
		Board board = service.get(bno);
		model.addAttribute("board", board);
		return "board/get";
	}
	
	@GetMapping("/register")
	public String registerForm() {
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register(Board board, RedirectAttributes rtts) {
		service.insert(board);
		rtts.addFlashAttribute("message", board.getBno() + " 번 등록함");
		return "redirect:/";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rtts) {
		service.remove(bno);
		rtts.addFlashAttribute("message", bno + " 번 삭제함");
		return "redirect:/";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "board/modify";
	}
	
	@PostMapping("/update")
	public String update(Board board, RedirectAttributes rtts) {
		service.update(board);
		rtts.addFlashAttribute("message", board.getBno() + " 번 내용 수정");
		return "redirect:/";
		
	}
	

}
