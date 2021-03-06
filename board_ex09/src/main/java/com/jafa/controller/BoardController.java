package com.jafa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.model.Board;
import com.jafa.model.Criteria;
import com.jafa.model.pageMaker;
import com.jafa.service.BoardServiceImpl;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	BoardServiceImpl service;
	
	@GetMapping("/list")
	public String getList(Criteria criteria, Model model) {
		pageMaker maker = new pageMaker(criteria, service.totalCount(criteria));
		
		List<Board> list = service.getList(criteria);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", maker);
		return "board/list";
	}
	
	@GetMapping("/get")
	public String get(Long bno, Criteria criteria, Model model) {
		pageMaker maker = new pageMaker(criteria, service.totalCount(criteria));
		Board board = service.findByBno(bno);
		model.addAttribute("board", board);
		model.addAttribute("pageMaker", maker);
		return "board/get";
		
	}
	
	
}
