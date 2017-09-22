package it.uniroma3.catalogo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.uniroma3.catalogo.domain.Product;
import it.uniroma3.catalogo.exception.ProductNotFoundException;
import it.uniroma3.catalogo.service.ProductService;

public class ProductIdValidator implements ConstraintValidator<ProductId, String>{

	@Autowired
	private ProductService productService;
	
	@Override
	public void initialize(ProductId constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		Product product;
		try {
			product = productService.getProductById(value);
		} catch (ProductNotFoundException e) {
			return true;
		}
		if(product != null)
		   return false;
		return true;
	}
	

}
