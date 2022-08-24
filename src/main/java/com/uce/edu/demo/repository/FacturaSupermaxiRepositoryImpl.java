package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Cliente;
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

	@Override
	public FacturaSupermaxi buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<FacturaSupermaxi> miTypedQuery = this.entityManager
				.createQuery("SELECT f FROM FacturaSupermaxi f WHERE f.numero = :datoNumero", FacturaSupermaxi.class);
		miTypedQuery.setParameter("datoNumero", numero);
		return miTypedQuery.getSingleResult();
	}
	
	
}
