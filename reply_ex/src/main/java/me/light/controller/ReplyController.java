package me.light.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.light.model.ReplyVo;
import me.light.service.ReplyService;

@RestController
@RequestMapping("/replies/")
public class ReplyController {

	@Autowired
	ReplyService service;
	
	@PostMapping(value ="/new",
							consumes = MediaType.APPLICATION_JSON_VALUE,
							produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody ReplyVo vo){
		int registerInsert = service.register(vo);
		return registerInsert == 1 
				?	new ResponseEntity<>("success", HttpStatus.OK)
				:  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
		@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
					value ="/{rno}",
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.TEXT_PLAIN_VALUE)
		public ResponseEntity<String> modify(@RequestBody ReplyVo vo, @PathVariable Long rno){
		vo.setRno(rno);
		int modifyInt = service.modify(vo);
		return modifyInt == 1 
		?	new ResponseEntity<>("success", HttpStatus.OK)
		:  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
	
}
