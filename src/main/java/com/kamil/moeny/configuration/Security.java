package com.kamil.moeny.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Security {
	
	
	@Autowired
	private MyUsrDetailService userDetailService;

	@Autowired
	private AuthenticationManager manager;

	BCryptPasswordEncoder endoder = new BCryptPasswordEncoder();
	
	public boolean login(String login, String password) {
		
		boolean isLogged = false;
		UserDetails userFound = userDetailService.loadUserByUsername(login);
		UserDetails userDetails = userFound;
		UsernamePasswordAuthenticationToken usernamePasswordAuthToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());
		manager.authenticate(usernamePasswordAuthToken);

		if (usernamePasswordAuthToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthToken);
			isLogged = true;
			System.out.println("logged as "+login);
			
		}
		
		return isLogged;
	}
}
