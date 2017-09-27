package it.uniroma3.catalogo.repository.impl;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import it.uniroma3.catalogo.domain.Cart;
import it.uniroma3.catalogo.domain.CartItem;
import it.uniroma3.catalogo.domain.Product;
import it.uniroma3.catalogo.repository.CartRepository;

@Repository
public class InMemoryCartRepository implements CartRepository{

	
	@PersistenceContext(unitName="Catalogo")
	EntityManager em;
	
	public void create(Cart cart) {
		em.persist(cart);
	}

	public void delete(String id) {
		Cart c = em.find(Cart.class, id);
		em.remove(c);
	}

	public void addItem(Cart cartId, String productId) {
		CartItem newItem = new CartItem();
		newItem.setProduct(em.find(Product.class, productId));
		newItem.setCart(em.find(Cart.class, cartId));
		
		em.persist(newItem);
	}


	@Override
	public void removeItem(String cartId, String productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getPurchasedProduct(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}
	//
//	@Override
//	public List<Product> getPurchasedProduct(Cart cart) {
//		List<CartItem> items = cart.getCartItems();
//		return em.createQuery("SELECT p FROM Product, CartItems c WHERE c.product = p.IN ", );
//	}

	

}
