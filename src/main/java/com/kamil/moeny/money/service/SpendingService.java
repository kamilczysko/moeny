package com.kamil.moeny.money.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamil.moeny.money.repository.SpendingRepo;

@Service
public class SpendingService {

	@Autowired
	private SpendingRepo repo;
}
