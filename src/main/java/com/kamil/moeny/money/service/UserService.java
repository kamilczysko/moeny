package com.kamil.moeny.money.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamil.moeny.money.model.AuthUser;
import com.kamil.moeny.money.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public Boolean auth(String login, String password) {
		AuthUser foundUser = repo.findByLogin(login);
		
		return (foundUser.login.equals(login) && foundUser.password.equals(password));
	}
}
