package it.uniroma3.catalogo.service;

import it.uniroma3.catalogo.domain.Cart;

public interface CartService {
	
	void create(Cart cartDto);
	void delete(String id);
	void addItem(Cart cartId, String productId);
	void removeItem(String cartId, String productId);

}
