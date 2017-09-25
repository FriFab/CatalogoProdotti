package it.uniroma3.catalogo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.catalogo.domain.Supplier;
import it.uniroma3.catalogo.repository.SupplierRepository;

public class InMemorySupplierRepository implements SupplierRepository{

	
	@PersistenceContext(unitName = "Catalogo")
	private EntityManager em;
	
	@Override
	@Transactional
	public void create(Supplier supplier) {
		em.persist(supplier);
	}

	@Override
	@Transactional
	public void delete(String id) {
	    em.remove(em.find(Supplier.class, id));
		
	}

	@Override
	public List<Supplier> getSuppliers() {
		return em.createQuery("SELECT * FROM Supplier", Supplier.class).getResultList();
	}

	@Override
	public Supplier getSupplierById(String id) {
		return em.createQuery("SELECT s FROM Supplier WHERE s.id = "+id, Supplier.class).getSingleResult();
	}

}
