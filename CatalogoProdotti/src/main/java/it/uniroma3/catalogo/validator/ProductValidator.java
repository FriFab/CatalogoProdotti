package it.uniroma3.catalogo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.catalogo.domain.Product;

public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Product.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "name", "Campo Obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "unitPrice", "Campo Obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "manufacturer", "Campo Obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "category", "Campo Obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "unitsInStock", "Campo Obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "unitsInOrder", "Campo Obbligatorio");

	}

}
