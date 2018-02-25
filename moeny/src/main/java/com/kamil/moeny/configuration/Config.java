package com.kamil.moeny.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kamil.moeny.service.CategoryService;
import com.kamil.moeny.service.SpendingService;
import com.kamil.moeny.service.UserService;
import com.kamil.moeny.ui.CategoryComponent;

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
	
//	@Bean
//	public CategoryComponent categoryComponent(){
//		return new CategoryComponent();
//	}
}
