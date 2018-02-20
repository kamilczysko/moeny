package com.kamil.moeny.money.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Spending {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@NotNull
	public float moneySpent;

	@NotNull
	public Date presentMoment;

	@NotNull
	@OneToOne
	public AuthUser user;

	@NotNull
	@OneToOne
	public Category category;
}
