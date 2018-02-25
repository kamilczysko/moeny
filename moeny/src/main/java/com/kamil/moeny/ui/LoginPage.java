package com.kamil.moeny.ui;


import org.springframework.beans.factory.annotation.Autowired;

import com.kamil.moeny.configuration.Security;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path="/login")
//@UIScope
public class LoginPage extends UI{

	private Panel panel = new Panel("Login");
	private FormLayout content = new FormLayout();
	private TextField username = new TextField("Username");
	private PasswordField password = new PasswordField("Password");
	private Button send = new Button("Enter");

	private VerticalLayout vLay = new VerticalLayout();
		
	@Autowired
	private Security sec;
	
	public LoginPage(){
		panel.setSizeUndefined();
		

//		send.addClickListener(new ClickListener() {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void buttonClick(ClickEvent event) {
//				if(VaadinloginUI.AUTH.authenticate(username.getValue(), password.getValue())){
//					VaadinSession.getCurrent().setAttribute("user", username.getValue());
//					getUI().getNavigator().addView(SecurePage.NAME, SecurePage.class);
//					getUI().getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
//					Page.getCurrent().setUriFragment("!"+SecurePage.NAME);
//				}else{
//					Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
//				}
//			}
//			
//		});

	
	}

	@Override
	protected void init(VaadinRequest request) {
		vLay.addComponent(panel);
		
		content.addComponent(username);
		content.addComponent(password);
		content.addComponent(send);
		content.setSizeUndefined();
		content.setMargin(true);
		
		send.addClickListener(e -> {
			String login = username.getValue();
			String pass = password.getValue();
			
			if(sec.login(login, pass)){
				Notification.show("Success");
				getUI().getPage().setLocation("/main");
			}
		
				
				
		});
		
		panel.setContent(content);
		setContent(panel);
		
	}
}
