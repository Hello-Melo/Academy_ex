package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "Hello!");
		return "hello";
	}
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-templates";
	}
	
	@GetMapping("hello-string")
	// http에서 body부에 이 데이터를 직접 넣는다는 의미(ResponseBody)
	@ResponseBody
	public String helloString(@RequestParam("name") String name) {
		return "hello" + name ;
	}
	
	@GetMapping("hello-api")
	@ResponseBody
	public Home helloApi(@RequestParam("name") String name) {
		Home home = new Home();
		home.setName(name);
		return home;
	}
	
	static class Home {
		private String name;

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	
	
}
