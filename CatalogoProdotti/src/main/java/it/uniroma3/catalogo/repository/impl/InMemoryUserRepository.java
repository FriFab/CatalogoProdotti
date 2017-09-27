package it.uniroma3.catalogo.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.uniroma3.catalogo.domain.Cart;
import it.uniroma3.catalogo.domain.Product;
import it.uniroma3.catalogo.domain.User;
import it.uniroma3.catalogo.repository.UserRepository;

public class InMemoryUserRepository implements UserRepository{

	
	@PersistenceContext(unitName="Catalogo")
	EntityManager em;

	@Override
	public void addUser(User user) {		
		em.persist(user);
	}

	@Override
	public void delete(String id) {
		em.remove(em.find(User.class, id));
	}

	@Override
	public void getUserById(String id) {
		em.find(User.class, id);
	}

	public List<Product> getAllProducts() {
		return em.createQuery("SELECT * FROM products", Product.class).getResultList();
	}

	public List<Product> getPurchasedProducts(String id){
		Cart c = this.getCart(id);
		
		return em.createQuery("SELECT p FROM Product, Cart WHERE", Product.class).getResultList();
	}

	@Override
	public Cart getCart(String UserId) {
		return em.createQuery("SELECT c FROM User u, Cart c WHERE u.cart = c.id AND u.id = "+UserId, Cart.class).getSingleResult();
	}

	@Override
	public List<Product> getPurchasedProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public User info(String id) {
		return em.createQuery("SELECT u FROM User WHERE u.id = "+id, User.class).getSingleResult();
	}



}



