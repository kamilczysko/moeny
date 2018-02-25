package com.kamil.moeny.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.kamil.moeny.configuration.LoggedUser;
import com.kamil.moeny.model.Category;
import com.kamil.moeny.model.Usr;
import com.kamil.moeny.service.CategoryService;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringComponent
@UIScope
public class CategoryComponent extends VerticalLayout {

	private HorizontalLayout hLay;
	private ComboBox<Category> categoryBox;
	private List<Category> list;
		
	private Button setCatButton = new Button("Categories");

	private AddCategorySubWindow catWindow;
	
	private Usr user;
	
	@Autowired
	public CategoryComponent(CategoryService categoryService){
		
		this.user = ((LoggedUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		
		this.hLay = new HorizontalLayout();
		
		System.out.println("category Comp: "+user.id);
		this.list = categoryService.getAllCategories(this.user);

		this.categoryBox = new ComboBox<Category>();	
		
		
		hLay.addComponent(categoryBox);
		hLay.addComponent(setCatButton);
		
		this.addComponent(hLay);
		
		this.categoryBox.setItems(this.list);
		
		catWindow = new AddCategorySubWindow(categoryService, list, categoryBox);
		setCatButton.addClickListener(e -> {
			UI.getCurrent().addWindow(catWindow);
		});
		
	}

	public Category getSelectedCategory(){
		return this.categoryBox.getSelectedItem().get();
	}

	public void setUser(Usr user) {
		this.user = user;
	}
}
