package com.kamil.moeny;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Tet {
	
	@RequestMapping(value ="/")
	public RedirectView dupa(){
		return new RedirectView("/main");
	}
	
}
