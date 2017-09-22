package it.uniroma3.catalogo.service;

import java.util.List;

import it.uniroma3.catalogo.domain.Supplier;

public interface SupplierService {

	void create(Supplier supplier);
	void delete(String id);
	List<Supplier> getSuppliers();
	Supplier getSupplierById(String id);
}
