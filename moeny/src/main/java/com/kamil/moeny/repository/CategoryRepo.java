package com.kamil.moeny.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kamil.moeny.model.Category;
import com.kamil.moeny.model.Usr;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long>{
	public List<Category> findByUser(Usr user);
}
