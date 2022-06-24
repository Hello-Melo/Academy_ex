package me.light.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.light.mapper.BoardMapper;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardMapper mapper;
	
	
	@GetMapping("/list")
	public String getList(Model model) {
		model.addAttribute("list", mapper.getList());
		return "board/list";
	}
	
	@GetMapping("/get")
	public String get(Long bno, Model model) {
		model.addAttribute("board", mapper.get(bno));
		return "board/get";
	}
}
