package com.kamil.moeny.configuration;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kamil.moeny.model.Usr;

public class LoggedUser implements UserDetails{
	
	private Usr user;
	
	public LoggedUser(Usr user){
		this.user = user;
	}
	
	public Usr getUser(){
		return this.user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	
	@Override
	public String getPassword() {
		return user.password;
	}

	@Override
	public String getUsername() {
		return user.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
