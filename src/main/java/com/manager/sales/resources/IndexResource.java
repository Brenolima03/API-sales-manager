package com.manager.sales.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexResource {
	
	@RequestMapping("/") 
	public String index(Model model) {
		model.addAttribute("welcome", "Welcome to my sales app");
		return "index";
	}

}
