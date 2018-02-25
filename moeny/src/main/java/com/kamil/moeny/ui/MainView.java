package com.kamil.moeny.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.kamil.moeny.configuration.LoggedUser;
import com.kamil.moeny.model.Usr;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "/main")
@Theme("valo")
public class MainView extends UI{
	
	private	HorizontalLayout content;
		
	private Label userLabel;
	
	private Button logoutButton;
	
	private HorizontalLayout hLay;
	
	@Autowired
	private TransactionComponent transactionComponent;
	
	
	
	
	@Override
	protected void init(VaadinRequest request) {
		
		Usr user = ((LoggedUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
				
		this.hLay = new HorizontalLayout();
		this.userLabel = new Label("Welcome, unknown");
		this.userLabel.setValue("Welcome, "+user.login+"("+user.id+")");
				
		this.logoutButton = new Button("Logout", e -> {
			getUI().getPage().setLocation("/logout");
		});
		
		this.hLay.addComponent(userLabel);
		this.hLay.addComponent(logoutButton);		
		this.content = new HorizontalLayout();
//		content.setSizeFull();
		content.addComponent(hLay);
		content.addComponent(this.transactionComponent);		
		setContent(content);
//		hLay.setComponentAlignment(logoutButton, Alignment.TOP_CENTER);
//		content.setComponentAlignment(hLay, Alignment.TOP_CENTER);
//		hLay.setMargin(false);
	}
	
	public void setNameLabel(String login){
		this.userLabel.setValue("Welcome, "+login);
	}

	
}

