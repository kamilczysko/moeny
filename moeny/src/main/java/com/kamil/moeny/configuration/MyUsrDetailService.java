package com.kamil.moeny.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kamil.moeny.model.Usr;
import com.kamil.moeny.repository.UserRepo;

@Service
public class MyUsrDetailService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usr user = userRepo.findByLogin(login);
		if(user == null)
			 throw new UsernameNotFoundException(login); 
		return new LoggedUser(user);
	}

}
