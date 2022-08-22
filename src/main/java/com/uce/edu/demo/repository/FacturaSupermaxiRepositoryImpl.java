package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.FacturaSupermaxi;

@Repository
@Transactional
public class FacturaSupermaxiRepositoryImpl implements IFacturaSupermaxiRepository{

	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(FacturaSupermaxi factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public void actualizar(FacturaSupermaxi factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}
	
	
}
