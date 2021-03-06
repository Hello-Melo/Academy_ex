package com.jafa.contorller;

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
import com.jafa.model.PageMaker;
import com.jafa.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public String getList(Criteria criteria,  Model model) {
		PageMaker maker = new PageMaker();
		maker.setCri(criteria);
		maker.setTotalCount(service.totalCount());
		List<Board> list = service.getList(criteria);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", maker);
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

	@GetMapping("/modify")
	public String modify() {
		return "board/modify";
	}
	
	@PostMapping("/update")
	public String update(Board board, RedirectAttributes rtts) {
		service.update(board);
		rtts.addFlashAttribute("message", board.getBno() + " 번 수정함");
		return "redirect:/";
	}

	@PostMapping("/delete")
	public String delete(Long bno, RedirectAttributes rtts) {
		service.delete(bno);
		rtts.addFlashAttribute("message", bno + " 번 삭제함");
		return "redirect:/";
	}
	
	

}
	
	


