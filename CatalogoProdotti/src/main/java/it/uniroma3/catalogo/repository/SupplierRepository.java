package it.uniroma3.catalogo.repository;

import java.util.List;

import it.uniroma3.catalogo.domain.Supplier;

public interface SupplierRepository {

	void create(Supplier supplier);
	void delete(String id);
	List<Supplier> getSuppliers();
	Supplier getSupplierById(String id);
}
