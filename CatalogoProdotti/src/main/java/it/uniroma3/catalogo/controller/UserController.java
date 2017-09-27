package it.uniroma3.catalogo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.catalogo.domain.User;
import it.uniroma3.catalogo.service.UserService;

@Controller
public class UserController {
	
	
	private UserService UserService;
	
	@RequestMapping("/user/{id}")
	public String list(Model model, @PathVariable("id") String id) {
	
		model.addAttribute("user", UserService.info(id));
		return "user";
	}
	
	@RequestMapping(value = "/user/new", method = RequestMethod.POST)
	public String addNewUserForm(@ModelAttribute("newUser") User newUser, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) return "addUser";
		
		String[] suppressedFields = result.getSuppressedFields();
		if(suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		UserService.addUser(newUser);
		return "redirect:/user";
		
	}

}
