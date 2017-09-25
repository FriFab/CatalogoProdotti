package it.uniroma3.catalogo.repository;

import java.util.List;

import it.uniroma3.catalogo.domain.Cart;
import it.uniroma3.catalogo.domain.Product;

public interface CartRepository {
	
	void create(Cart cart);
	void delete(String id);
	void addItem(String cartId, String productId);
	void removeItem(String cartId, String productId);
	List<Product> getPurchasedProduct();

}
