package it.uniroma3.catalogo.repository.impl;


import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;


import org.springframework.stereotype.Repository;

import it.uniroma3.catalogo.domain.Product;
import it.uniroma3.catalogo.repository.ProductRepository;


@Repository
public class InMemoryProductRepository implements ProductRepository{

	
	private EntityManager em;
	
	public List<Product> getAllProducts() {
		List<Product> result = em.createQuery("SELECT * FROM Product", Product.class).getResultList();
		return result;
	}

	public void updateStock(String productId, long noOfUnits) {
	
	}

	public List<Product> getProductsByCategory(String category) {
		return em.createQuery("SELECT p FROM Product WHERE p.category = "+category, Product.class).getResultList();
	}
	
//	//da finire
//	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
//		return em.createQuery("SELECT p FROM Product WHERE p.category IN "+filterParams, Product.class).getResultList();
//	}

	public Product getProductById(String productId) {
		return em.createQuery("SELECT p FROM Product WHERE p.id = "+productId, Product.class).getSingleResult();
	}

	public void addProduct(Product product) {
		em.persist(product);
	}
	
	public void remove(String id) {
		em.remove(em.find(Product.class, id));
	}

	//	public List<Product> filterProducts(String category, Map<String, List<String>> filterParams) {
	//		String SQL = "SELECT * FROM PRODUCTS WHERE CATEGORY = (:categories) AND UNITPRICE BETWEEN (:low) AND (:high) AND MANUFACTERED IN (:brands)";
	//		return jdbcTemplate.query(SQL, filterParams, new ProductMapper());
	//	}













}