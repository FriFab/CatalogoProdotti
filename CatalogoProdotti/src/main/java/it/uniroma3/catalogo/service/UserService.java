package it.uniroma3.catalogo.service;

import it.uniroma3.catalogo.domain.Cart;
import it.uniroma3.catalogo.domain.User;

public interface UserService {
	


	User info(String id);

	void addUser(User user);

	Cart getCart(String id);

}
