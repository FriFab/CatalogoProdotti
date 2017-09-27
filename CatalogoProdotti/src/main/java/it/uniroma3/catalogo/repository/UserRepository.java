package it.uniroma3.catalogo.repository;

import java.util.List;

import it.uniroma3.catalogo.domain.Cart;
import it.uniroma3.catalogo.domain.Product;
import it.uniroma3.catalogo.domain.User;

public interface UserRepository {

	void delete(String id);
	void getUserById(String id);
	Cart getCart(String UserId);
	
	List<Product> getAllProducts();
	List<Product> getPurchasedProduct();
	User info(String id);
	void addUser(User newUser);
}
