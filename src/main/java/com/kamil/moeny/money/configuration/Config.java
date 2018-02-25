package com.kamil.moeny.money.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kamil.moeny.money.service.CategoryService;
import com.kamil.moeny.money.service.SpendingService;
import com.kamil.moeny.money.service.UserService;

@Configuration
public class Config {

	
	@Bean
	public UserService userService() {
		return new UserService();
	}
	
	@Bean
	public SpendingService spendingService() {
		return new SpendingService();
	}
	
	@Bean
	public CategoryService categoryService() {
		return new CategoryService();
	}
}
