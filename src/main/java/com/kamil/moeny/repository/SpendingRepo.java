package com.kamil.moeny.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kamil.moeny.model.Spending;
import com.kamil.moeny.model.Usr;

@Repository
public interface SpendingRepo extends CrudRepository<Spending, Long>{

	public List<Spending> findAllByUser(Usr user);
}
