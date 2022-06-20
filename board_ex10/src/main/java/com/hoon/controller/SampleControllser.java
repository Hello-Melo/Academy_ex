package com.hoon.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoon.model.SampleVo;

@RestController
@RequestMapping("/sample")
public class SampleControllser {

	@GetMapping(value = "/getText", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String getText(){
		return "안녕하세유~";
	}
	
	@GetMapping(value="/getSample", produces = {MediaType.APPLICATION_JSON_VALUE
			, MediaType.APPLICATION_XML_VALUE} )
	public SampleVo getSample() {
		return new SampleVo(112, "고길", "동");
	}
	
	
	@GetMapping(value = "/sampleList", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<SampleVo> sampleList(){
		List<SampleVo> list = new ArrayList<SampleVo>();
		list.add(new SampleVo(1, "길동", "동"));
		list.add(new SampleVo(2, "길동", "박"));
		list.add(new SampleVo(3, "길동", "김"));
		list.add(new SampleVo(4, "길덩", "사"));
		return list;
	}
	
	@GetMapping(value = "/getMap", produces= {MediaType.APPLICATION_JSON_VALUE})
	public Map<String, SampleVo> getMap(){
		HashMap<String, SampleVo> map = new HashMap<String, SampleVo>();
		map.put("first", new SampleVo(1, "박길"," 동"));
		map.put("second", new SampleVo(2, "박길"," 김"));
		return map;
	}
	
	// /member/1 요청하면 1번이 호출
	@GetMapping(value = "/member/{id}")
	public String[] getPath(@PathVariable String id) {
		return new String[] {id, "고길동"};
	}
	
	
	
	
}
