package me.Hoon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.Hoon.controller.HomeController;

@Configuration
public class RootConfig {

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
	
}
