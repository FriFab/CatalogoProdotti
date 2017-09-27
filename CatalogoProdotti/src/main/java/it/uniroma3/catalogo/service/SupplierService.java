package it.uniroma3.catalogo.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.catalogo.domain.Supplier;

public interface SupplierService {

	@Secured({"ROLE_ADMIN"})
	void create(Supplier supplier);
	@Secured({"ROLE_ADMIN"})
	void delete(String id);
	
	List<Supplier> getSuppliers();
	
	Supplier getSupplierById(String id);
}
