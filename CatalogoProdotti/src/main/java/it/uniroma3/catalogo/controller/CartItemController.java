package it.uniroma3.catalogo.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.catalogo.domain.Cart;
import it.uniroma3.catalogo.service.CartService;

@RestController
@RequestMapping(value = "rest/cart")
public class CartItemController {

	
	private CartService cartService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void create(@RequestBody Cart cartDto) {
		cartService.create(cartDto);
	}

//	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
//	private Cart read(@PathVariable(value = "cartId") String cartId) {
//		return cartService.read(cartId);
//	}
//
//	@RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
//	@ResponseStatus(value = HttpStatus.OK)
//	public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cartDto) {
//		cartDto.setId(cartId);
//		cartService.update(cartId, cartDto);
//	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "cartId") String cartId) {
		cartService.delete(cartId);
	}
	
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void addItem(@PathVariable String productId, HttpSession session) {
		cartService.addItem((Cart)session.getAttribute("cart"),productId);
	}
	
	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void removeItem(@PathVariable String productId, HttpSession session) {
		cartService.removeItem(session.getId(),productId);
	}


}
