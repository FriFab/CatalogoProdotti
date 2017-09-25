package it.uniroma3.catalogo.repository;

import java.util.List;
import java.util.Map;

import it.uniroma3.catalogo.domain.Product;

public interface ProductRepository {
	
	List<Product> getAllProducts();
	void updateStock(String productID, long noOfUnits);
	List<Product> getProductsByCategory(String category);
    List<Product> getProductsByFilter(Map<String, List<String>> filterParams);  
    Product getProductById(String productId);
    
    //List<Product> filterProducts(Map<String, List<String>> filterParams);
    
    void addProduct(Product product);
    void remove(String id);

}
