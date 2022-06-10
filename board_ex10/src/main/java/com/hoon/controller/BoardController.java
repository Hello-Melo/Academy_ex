package com.hoon.controller;

import java.util.List;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoon.model.Board;
import com.hoon.service.BoardService;
import com.hoon.service.BoardServiceImpl;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	BoardServiceImpl service;
	
	@GetMapping("/list")
	public String getList(Model model) {
		List<Board> list = service.getList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
}