package com.jafa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.model.Board;
import com.jafa.model.Criteria;
import com.jafa.model.pageMaker;
import com.jafa.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	BoardService service;
	
	
	@GetMapping("/list")
	public String getList(Model model, Criteria criteria) {
		pageMaker maker = new pageMaker(criteria, service.totalCount(criteria));
		
		List<Board> list = service.getList(criteria);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", maker);
		return "board/list";
	}
	
	@GetMapping("/get")
	public String get(Long bno, Criteria criteria, Model model) {
		pageMaker maker = new pageMaker(criteria, service.totalCount(criteria));
		Board board = service.get(bno, criteria);
		model.addAttribute("board", board);
		model.addAttribute("pageMaker", maker);
		
		return "board/get";
	}
	
	@GetMapping("/register")
	public String insert() {		
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register(RedirectAttributes rtts, Board board) {
		service.insert(board);
		rtts.addFlashAttribute("message", board.getBno() + "번 등록함");
		return "redirect:/";
	}
	
	@PostMapping("/remove")
	public String delete(Long bno, RedirectAttributes rtts) {
		service.delete(bno);
		rtts.addAttribute("message", bno + "번 삭제함");
		return "redirect:/";
		}
	
	@GetMapping("/update")
	public String modifyForm() {
		return "board/update";
	}
	
	@PostMapping("/update")
	public String update(Board board, RedirectAttributes rtts) {
		service.update(board);
		rtts.addAttribute("message", board.getBno() + "번 수정함");
		return "redirect:/";
	}
	
	
}
