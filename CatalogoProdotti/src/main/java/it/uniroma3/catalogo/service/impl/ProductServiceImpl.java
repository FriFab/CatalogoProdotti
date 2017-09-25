package it.uniroma3.catalogo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.catalogo.domain.Product;
import it.uniroma3.catalogo.repository.ProductRepository;
import it.uniroma3.catalogo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	public void updateAllStock() {
		List<Product> allProducts =	productRepository.getAllProducts();
		for(Product product : allProducts) {
			if(product.getUnitsInStock()<500)
				productRepository.updateStock(product.getProductId(),product.getUnitsInStock()+1000);
		}
	}
	
	public List<Product> getAllProducts() {
	    return productRepository.getAllProducts();
	}


	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}


	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}
	
	public Product getProductById(String id) {
		return productRepository.getProductById(id);
	}

	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

//	public List<Product> filterProducts(String category, Map<String, List<String>> filterParams) {
//		return productRepository.filterProducts(category, filterParams);
//	}
	

}
