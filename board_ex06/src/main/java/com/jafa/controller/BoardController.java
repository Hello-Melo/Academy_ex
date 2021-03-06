package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.model.Criteria;
import com.jafa.model.pageMaker;
import com.jafa.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public String getList(Criteria criteria, Model model) {
		pageMaker pagemaker = new pageMaker(criteria);
		pagemaker.setCriteria(criteria);
		pagemaker.setTotalCount(service.totalCount());
		
		model.addAttribute("list", service.getList(criteria));
		model.addAttribute("pageMaker", pagemaker);
		return "board/list";
	}
	
	
	
}
