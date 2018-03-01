package com.kamil.moeny.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamil.moeny.model.Usr;
import com.kamil.moeny.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public void save(Usr user){
		repo.save(user);
	}
}
