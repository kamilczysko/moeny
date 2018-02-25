package com.kamil.moeny.ui;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.context.SecurityContextHolder;

import com.kamil.moeny.configuration.LoggedUser;
import com.kamil.moeny.model.Category;
import com.kamil.moeny.model.Usr;
import com.kamil.moeny.service.CategoryService;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

//@SpringUI
//@UIScope
public class AddCategorySubWindow extends Window{

	private VerticalLayout vLay;
	private HorizontalLayout hLay;

	private Button addButton, removeButton;
	private TextField categoryField;
	private List<Category> list;
	private Grid<Category> grid;
	
	private CheckBox costOrNot;
	
	private ComboBox comboBox;
	
	private CategoryService categoryService;
	
	private Usr user;
	
	public AddCategorySubWindow(CategoryService catService, List<Category> catList, ComboBox comboBox){
		super("Categories");
		center();
		setHeight("600px");
		setWidth("700px");
		
		this.comboBox = comboBox;
		
		this.user = ((LoggedUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		
		this.costOrNot = new CheckBox("Income");
		this.categoryService = catService;
		this.list = catList;
		this.vLay = new VerticalLayout();
		this.hLay = new HorizontalLayout();
		this.addButton = new Button("add", e->{
			this.addItem();
			categoryField.clear();
		});
		this.removeButton = new Button("remove", e -> {
			this.removeItem();
		});
		this.categoryField = new TextField();
		
		this.grid = new Grid<Category>();
		grid.setSelectionMode(SelectionMode.MULTI);
		grid.setItems(this.list);
		this.grid.addColumn(Category::getName).setCaption("Name");
		this.grid.addColumn(Category::isincome).setCaption("Income");
		
		setContent(vLay);
		
		hLay.addComponent(costOrNot);
		hLay.addComponent(categoryField);
		hLay.addComponent(addButton);
		
		vLay.addComponent(hLay);
		vLay.addComponent(grid);
		vLay.addComponent(removeButton);
	}
	
	private void addItem() {
		System.out.println("Adding item for:"+ this.user.id);
		Category category = new Category(this.categoryField.getValue().toString(), this.costOrNot.getValue());
		category.user = this.user;
		Category added = categoryService.addCategory(category);
		
		this.list.add(added);
		this.grid.setItems(this.list);
		
		
		this.refreshComboBox();
		
	}

	private void removeItem() {
		Set<Category> items = this.grid.getSelectedItems();
		this.categoryService.deleteCategories(items);
		
		this.list.remove(items);
	
		items.forEach(e -> this.list.remove(e));
	
		this.grid.setItems(this.list);
		
		this.refreshComboBox();
	}	
	
	private void refreshComboBox(){
		this.comboBox.clear();
		this.comboBox.setItems(this.list);
	}
		
}
