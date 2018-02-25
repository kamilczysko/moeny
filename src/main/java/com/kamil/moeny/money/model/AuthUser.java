package com.kamil.moeny.money.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class AuthUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	@Column(unique = true)
	public String login;
	
	@NotNull
	public String name;
	
	@NotNull
	public String password;
	
	@NotNull
	public float actual;
	
	@NotNull
	public Date startDate;
}
