package com.kamil.moeny.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.kamil.moeny.model.Usr;
import com.kamil.moeny.repository.UserRepo;

@Component
public class UserDbPrep implements CommandLineRunner{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public void run(String... arg0) throws Exception {
		Usr us = new Usr("kamil", new BCryptPasswordEncoder().encode("kamil"));
		Usr us2 = new Usr("pszemek", new BCryptPasswordEncoder().encode("pszemek"));
		userRepo.save(us);
		userRepo.save(us2);
	}
	
}
