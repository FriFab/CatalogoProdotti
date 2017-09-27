package it.uniroma3.catalogo.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.catalogo.domain.Product;

public interface ProductService {
	
	void updateAllStock();
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByCategory(String category);
	
	//List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	Product getProductById(String productID);
	
	//List<Product> filterProducts(String category, Map<String, List<String>> filterParams);
	
	@Secured({"ROLE_ADMIN"})
	void addProduct(Product product);
	
	

}
