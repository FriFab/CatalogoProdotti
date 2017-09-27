package it.uniroma3.catalogo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.catalogo.domain.User;
import it.uniroma3.catalogo.service.CartService;
import it.uniroma3.catalogo.service.UserService;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
	
	private CartService cartService;
	private UserService userService;
	
	@RequestMapping
	public String get(HttpServletRequest request) {
		return "redirect:/cart/" + request.getSession(true).getId();
	}
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public String getCart(@PathVariable(value = "cartId") String cartId, Model model) {
		model.addAttribute("cartId", cartId);
		return "cart";
	}
	
//	@RequestMapping(value ="/cart/add/{productId}", method = RequestMethod.POST)
	public String addToCart(Model model,@PathVariable("productId") String productId, User user) {
		cartService.addItem(userService.getCart(user.getID()), productId);
		return "cart";
	}

}
