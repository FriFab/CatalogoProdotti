package it.uniroma3.catalogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.catalogo.service.UserService;

@Controller
public class UserController {
	
	
	private UserService UserService;
	
	@RequestMapping("/user/{id}")
	public String list(Model model) {
	
		model.addAttribute("customers", UserService.getAllProducts());
		return "products";
	}

}
