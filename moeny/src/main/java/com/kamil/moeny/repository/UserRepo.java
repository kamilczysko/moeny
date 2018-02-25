package com.kamil.moeny.repository;

import org.springframework.data.repository.CrudRepository;

import com.kamil.moeny.model.Usr;

public interface UserRepo extends CrudRepository <Usr, Long>{
	
	Usr findByLogin(String login);
	
}
