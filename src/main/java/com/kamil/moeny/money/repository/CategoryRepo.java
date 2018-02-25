package com.kamil.moeny.money.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kamil.moeny.money.model.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long>{

}
