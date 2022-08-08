package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN f.detalleFacturas d WHERE d.cantidad > :datoCantidad", Factura.class);
		myQuery.setParameter("datoCantidad", cantidad);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalleFacturas d",
				Factura.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalleFacturas d WHERE d.cantidad > :datoCantidad",
				Factura.class);
		myQuery.setParameter("datoCantidad", cantidad);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturalOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalleFacturas d", Factura.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturalOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalleFacturas d WHERE d.cantidad > :datoCantidad",
				Factura.class);
		myQuery.setParameter("datoCantidad", cantidad);

		return myQuery.getResultList();
	}

}
