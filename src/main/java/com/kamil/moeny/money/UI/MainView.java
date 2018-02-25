package com.kamil.moeny.money.UI;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI(path = "/login")
@Title("Login")
@Theme("valo")
public class MainView extends UI{

	@Override
	protected void init(VaadinRequest request) {
		
	}

}
