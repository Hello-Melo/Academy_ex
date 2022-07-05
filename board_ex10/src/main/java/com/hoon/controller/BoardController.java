package com.hoon.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hoon.model.Board;
import com.hoon.model.BoardAttachVo;
import com.hoon.model.Criteria;
import com.hoon.model.PageMaker;
import com.hoon.service.BoardService;
import com.hoon.service.BoardServiceImpl;
import com.hoon.validation.BoardValidatior;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	BoardService service;

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
//		  new BoardValidatior().validate(board, errors);
//		  if (errors.hasErrors()) {
//			  return "board/register"; 
//			  }
		return "redirect:/board/list";
	}

	@GetMapping("/get")
	public String get(Long bno, Model model) {
		model.addAttribute("board", service.findByBno(bno));
		return "board/get";
	}

	@GetMapping("/update")
	public String updateForm(Model model) {
		
		return "board/update";
	}

	@PostMapping("/update")
	public String update(Board board, RedirectAttributes rtts) {
		service.update(board);
		return "redirect:/board/list";
	}

	@PostMapping("/delete")
	public String remove(Long bno, RedirectAttributes rtts) {
		List<BoardAttachVo> list = service.getAttachList(bno);
		deleteFiles(list);
		service.delete(bno);
		
		System.out.println(bno);
		return "redirect:/board/list";
	}

	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVo>> getAttachList(Long bno) {
		List<BoardAttachVo> attachList = service.getAttachList(bno);

		return new ResponseEntity<>(attachList, HttpStatus.OK);
	}

	private void deleteFiles(List<BoardAttachVo> list) {
		if (list == null || list.size() == 0)
			return;

		list.forEach(attach -> {
			// uploadPath, uuid, fileName (내가 설정했던 주소 형식을 그대로 써주는것!)

			Path file = Paths.get("c:/upload/" + attach.getUploadPath() + "/" + attach.getUuid() + "_" + attach.getFileName());
			System.out.println(file);
			try {
				// 파일이 있을시 파일을 삭제, 없을시 무시
				Files.deleteIfExists(file);
				// 만약 파일 형태가 이미지 파일 형태라면 썸네일도 삭제하라는 조건문!
				if (Files.probeContentType(file).startsWith("image")) {
					Path thumbnail = Paths.get("c:/upload/" + attach.getUploadPath() + "/s_" + attach.getUuid() + "_" + attach.getFileName());
					System.out.println(thumbnail);
					Files.deleteIfExists(thumbnail);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}