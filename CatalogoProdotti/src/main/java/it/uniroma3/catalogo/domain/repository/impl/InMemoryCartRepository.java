package it.uniroma3.catalogo.domain.repository.impl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import it.uniroma3.catalogo.domain.Cart;
import it.uniroma3.catalogo.domain.CartItem;
import it.uniroma3.catalogo.domain.Product;
import it.uniroma3.catalogo.domain.repository.CartRepository;
import it.uniroma3.catalogo.service.ProductService;

@Repository
public class InMemoryCartRepository implements CartRepository{

	@Autowired
	@PersistenceContext(unitName="Catalogo")
	EntityManager em;
	
	public void create(Cart cart) {
		em.persist(cart);
	}

	public void delete(String id) {
		Cart c = em.find(Cart.class, id);
		em.remove(c);
	}

	public void addItem(String cartId, String productId) {
	}

	@Override
	public void removeItem(String cartId, String productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getPurchasedProduct() {
		return null;
	}

	

}
