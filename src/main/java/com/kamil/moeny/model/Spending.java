package com.kamil.moeny.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Spending {

	public Spending(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

//	@NotNull
	public float moneySpent;

//	@NotNull
	public LocalDate presentMoment;

//	@NotNull
	@OneToOne
	public Usr user;

	public String transaction_name;
	
//	@NotNull
	@OneToOne
	public Category category;
	
	public float getSpend(){
		return this.moneySpent;
	}
	
	public LocalDate moment(){
		return this.presentMoment;
	}
	
	public Category getCategory(){
		return this.category;
	}
	
	public String getName(){
		return transaction_name;
	}
	
}
