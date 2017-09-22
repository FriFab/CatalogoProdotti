package it.uniroma3.catalogo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.uniroma3.catalogo.domain.Supplier;
import it.uniroma3.catalogo.domain.repository.SupplierRepository;
import it.uniroma3.catalogo.service.SupplierService;

public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public void create(Supplier supplier) {
		this.supplierRepository.create(supplier);		
	}

	@Override
	public void delete(String id) {
		this.supplierRepository.delete(id);
	}

	@Override
	public List<Supplier> getSuppliers() {
		return this.supplierRepository.getSuppliers();
	}

	@Override
	public Supplier getSupplierById(String id) {
		return this.supplierRepository.getSupplierById(id);	
	}

}
