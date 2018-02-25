package com.kamil.moeny.ui;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.vaadin.ui.NumberField;

import com.kamil.moeny.configuration.LoggedUser;
import com.kamil.moeny.model.Category;
import com.kamil.moeny.model.Spending;
import com.kamil.moeny.model.Usr;
import com.kamil.moeny.service.SpendingService;
import com.kamil.moeny.service.UserService;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToFloatConverter;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@UIScope
public class TransactionComponent extends VerticalLayout{
	
//	private VerticalLayout vLay;
	
	private HorizontalLayout hLay;
	
	private TextField tranasactionName;
	
	private DateField date;
	
//	private TextField cost;
	private NumberField cost;
	
	private Button add,remove;
	
	private CategoryComponent catComponent;
	
	private Grid<Spending> grid;
	
	private SpendingService spendingService;
	
	private Binder<Spending> b;
	
	private Label sum;
		
	private List<Spending> list;
	
	private Usr user;
	
	
	private UserService userService;
	
	@Autowired
	public TransactionComponent(CategoryComponent catComponent, SpendingService spendingService, UserService userService){
				
		this.user = ((LoggedUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		
		
		this.userService = userService;
//		this.vLay = new VerticalLayout();
		this.spendingService = spendingService;
		System.out.println("pobranie transakcji"+ user.id);
		this.list = spendingService.getTransactions(this.user);
		
		this.cost = new NumberField("Cost");
		this.cost.setDecimalAllowed(true);
		this.cost.setDecimalPrecision(2);
		
		this.b = new Binder();
		b.forField(cost)
		.withConverter(new StringToFloatConverter("Must be decimal number"));
		
		this.catComponent = catComponent;
			
		this.tranasactionName = new TextField("Transaction name");
		this.date = new DateField();
		this.date.setDateFormat("yyyy-MM-dd");
		this.date.setValue(LocalDate.now());
		
		this.add = new Button("add", e-> addTransaction());
		this.remove = new Button("remove", e -> removeTransaction());
		this.hLay = new HorizontalLayout();
		
		this.sum = new Label("Sum: "+this.user.actual_balance);
		
		this.hLay.addComponent(add);
		this.hLay.addComponent(remove);
				
		addComponent(tranasactionName);
		addComponent(cost);
		addComponent(date);
		addComponent(catComponent);
		addComponent(hLay);
		
		this.grid = new Grid<Spending>();
		this.grid.setSelectionMode(SelectionMode.SINGLE);
		this.grid.setItems(list);

		updateSum();
		
		this.grid.addColumn(Spending::getSpend).setCaption("Cost");
		this.grid.addColumn(Spending::getName).setCaption("Transaction");		
		this.grid.addColumn(Spending::getCategory).setCaption("Category");
		this.grid.addColumn(Spending::moment).setCaption("When");
		
		addComponent(grid);
		addComponent(sum);
		
		
		setSizeUndefined();
	}
	
	private int f = 1;
	
	private void addTransaction(){
		Spending s = new Spending();
		Category cat = catComponent.getSelectedCategory();
		if(!cat.income)
			f = -1;
		else f = 1;
		s.category = cat;
		s.moneySpent = Math.abs(Float.parseFloat(cost.getValue()))*f;
		s.transaction_name = tranasactionName.getValue().trim();
		s.presentMoment = this.date.getValue();
		s.user = this.user;
		
		Spending trans = spendingService.addTransaction(s);
		
		this.list.add(trans);
		this.grid.setItems(this.list);
		updateSum();
		updateUsersBalanceOnDB();
	}
	
	private void removeTransaction(){
		Spending s = this.grid.getSelectedItems().iterator().next();
		spendingService.removeTransaction(s);
		
		this.list.remove(s);
		this.grid.setItems(this.list);
		updateSum();
		updateUsersBalanceOnDB();
	}
	
	private void updateSum(){
		
		
		this.sum.setValue("Sum: "+getBalance());
		
	}
	
	private void updateUsersBalanceOnDB(){
		this.user.actual_balance = getBalance();
		this.userService.save(this.user);
	}

	private float getBalance(){
		float total = 0.0f;
		for(int i = 0; i < this.list.size(); i++)
			total += this.list.get(i).getSpend();
		return total;
	}
	
	
}
