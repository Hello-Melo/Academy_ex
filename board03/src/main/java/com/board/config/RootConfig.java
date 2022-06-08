package com.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.board.controller.HomeController;

@Configuration
public class RootConfig {

	
	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
	

	
}
