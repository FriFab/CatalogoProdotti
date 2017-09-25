package it.uniroma3.catalogo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.catalogo.domain.Product;
import it.uniroma3.catalogo.domain.User;
import it.uniroma3.catalogo.repository.UserRepository;
import it.uniroma3.catalogo.service.UserService;

@Service
public class UserServicsImpl implements UserService{
	
	
	private UserRepository userRepository;

	public List<Product> getAllProducts() {
		return userRepository.getAllProducts();
	}

}
