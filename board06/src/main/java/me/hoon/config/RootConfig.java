package me.hoon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.hoon.controller.HomeCotnlreoller;

@Configuration
public class RootConfig {
	
	@Bean
	public HomeCotnlreoller homeController() {
		return new HomeCotnlreoller();
	}

}
