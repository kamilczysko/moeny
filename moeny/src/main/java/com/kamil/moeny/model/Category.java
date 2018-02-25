package com.kamil.moeny.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Category {
	
	

	public Category(String category_name, boolean income) {
		this.category_name = category_name;
		this.income = income;
	}
	
	public Category() {}
	
	@NotNull
	public boolean income = true;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	public String category_name;
	
	@OneToOne
	public Usr user;
	
	public boolean isincome(){
		return this.income;
	}
		
	public String getName(){
		return this.category_name;
	}

	@Override
	public String toString() {
		
		return this.category_name;
	}
	
}
