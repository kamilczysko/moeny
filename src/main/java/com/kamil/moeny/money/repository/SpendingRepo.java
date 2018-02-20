package com.kamil.moeny.money.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kamil.moeny.money.model.Spending;

@Repository
public interface SpendingRepo extends CrudRepository<Spending, Long>{

}
