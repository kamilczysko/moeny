package com.kamil.moeny.money.repository;

import org.springframework.data.repository.CrudRepository;

import com.kamil.moeny.money.model.AuthUser;

public interface UserRepo extends CrudRepository <AuthUser, Long>{
	
	AuthUser findByLogin(String login);
	
}
