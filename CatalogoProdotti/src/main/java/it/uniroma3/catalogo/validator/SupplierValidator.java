package it.uniroma3.catalogo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.catalogo.domain.Supplier;

public class SupplierValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Supplier.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "name", "Campo Obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "address", "Campo Obbligatorio");
		
	}

}
