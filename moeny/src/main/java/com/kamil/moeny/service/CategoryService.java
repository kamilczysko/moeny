package com.kamil.moeny.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamil.moeny.model.Category;
import com.kamil.moeny.model.Usr;
import com.kamil.moeny.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	public CategoryRepo repo;
	
	public Category addCategory(Category c){
		
		return repo.save(c);
	}
	
	public void deleteCategory(Category c){
		repo.delete(c);
	}
	
	public void deleteCategories(Set<Category> list){
		repo.delete(list);
	}
	
	public List<Category> getAllCategories(){
		return (List<Category>) repo.findAll();
	}
	
	public List<Category> getAllCategories(Usr user){
		List<Category> list = ((List<Category>) repo.findByUser(user));
		System.out.println("get component: "+user.login+" "+list);
		return list;
	}
}
