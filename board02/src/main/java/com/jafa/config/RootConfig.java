package com.jafa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jafa.controller.HomeController;

@Configuration
public class RootConfig {

	
	
	
	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
	
}
