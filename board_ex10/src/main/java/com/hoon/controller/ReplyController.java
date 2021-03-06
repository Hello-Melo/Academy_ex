package com.hoon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoon.model.Criteria;
import com.hoon.model.ReplyVo;
import com.hoon.service.ReplyService;
import com.hoon.service.ReplyServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/replies/")
@AllArgsConstructor
public class ReplyController {

	private ReplyService service;
	
	@PostMapping(value="new",  
			consumes= MediaType.APPLICATION_JSON_VALUE , produces= {MediaType.TEXT_PLAIN_VALUE}) 
	public ResponseEntity<String> create(@RequestBody ReplyVo vo){
		int insertCount = service.register(vo);
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/pages/{bno}/{page}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ReplyVo>> getList(@PathVariable int page, @PathVariable Long bno){
		Criteria criteria = new Criteria(page, 10);
		return new ResponseEntity<>(service.getList(criteria, bno), HttpStatus.OK);
	}
	
	@GetMapping(value="/{rno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReplyVo> get(@PathVariable Long rno){
		return new ResponseEntity<ReplyVo>(service.get(rno), HttpStatus.OK);
	}

	@DeleteMapping(value="/{rno}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> remove(@PathVariable Long rno){
		return service.remove(rno) == 1 
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping(value="/{rno}")
	public ResponseEntity<String> modify(@RequestBody ReplyVo vo, @PathVariable Long rno){
		vo.setRno(rno);
		return service.modify(vo) == 1
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
}

