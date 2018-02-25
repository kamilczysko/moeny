package com.kamil.moeny.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamil.moeny.model.Spending;
import com.kamil.moeny.model.Usr;
import com.kamil.moeny.repository.SpendingRepo;

@Service
public class SpendingService {

	@Autowired
	private SpendingRepo repo;
	
	public void removeTransaction(Spending s){
		repo.delete(s);
	}
	
	public List<Spending> getTransactions(){
		return (List<Spending>) repo.findAll();
	}
	
	public List<Spending> getTransactions(Usr user){
		return (List<Spending>) repo.findAllByUser(user);
	}
	
	public Spending addTransaction(Spending s){
		return repo.save(s);
	}
}
