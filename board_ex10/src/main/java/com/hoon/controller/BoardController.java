package com.hoon.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
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

	@PreAuthorize("isAuthenticated()")
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
	public String get(Long bno, Model model, 
			@CookieValue(required = false) Cookie viewCount, 
			 HttpServletRequest request, HttpServletResponse response) {
		boolean isAddCount = false;
		if(viewCount != null) {
			// 이름이 viewcont 쿠키가 있을때
			String[] viewed = viewCount.getValue().split("/"); // 쿠키값 문자열을 배열로 선언
			System.out.println(viewed.toString());
			//ccontains메서드 사용을 위해 리스트 컬렉션으로 변환
			List<String> viewedList = Arrays.stream(viewed).collect(Collectors.toList());
					if(!viewedList.contains(bno.toString())) {//조회한 게시물 번호가 없다면
						viewCount.setValue(viewCount.getValue()+bno+"/"); //기존 쿠키값 조회한게시물
						response.addCookie(viewCount);//쿠키 없데이트
						isAddCount = true;
					}
			}	else {
			//쿠키가 없을때
			Cookie cookie = new Cookie("viewCount", bno + "/");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			isAddCount = true;
			}
		//두번째 인수는 조회수 증가 여부
		model.addAttribute("board", service.findByBno(bno, isAddCount));
		return "board/get";
	}
		
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/update")
	public String updateForm(Long bno, Model model) {
		model.addAttribute("board", service.findByBno(bno, false));
		return "board/update";
	}

	@PreAuthorize("isAuthenticated() and principal.username == #board.writer")
	@PostMapping("/update")
	public String update(Board board, RedirectAttributes rtts) {
		service.update(board, false);
		return "redirect:/board/list";
	}

	@PreAuthorize("isAuthenticated() and principal.username == #writer")
	@PostMapping("/delete")
	public String remove(Long bno, RedirectAttributes rtts, String writer) {
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