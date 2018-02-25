package com.kamil.moeny.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Usr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	@Column(unique = true)
	public String login;
	
	@NotNull
	public String password;


	public float actual_balance;
	
	@NotNull
	public Date startDate;
	
	public Usr(String login, String password){
		this.login = login;
		this.password = password;
		this.startDate = new Date();
		this.actual_balance = 0.0f;
	}
	
	public Usr(){
		this.startDate = new Date();
		this.actual_balance = 0.0f;
	}
}
