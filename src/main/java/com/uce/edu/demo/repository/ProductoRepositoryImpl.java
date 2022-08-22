package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Producto buscarCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> miTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :datoCodigo", Producto.class);
		miTypedQuery.setParameter("datoCodigo", codigoBarras);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public int actulizarStock(String codigoBarras) {
		// TODO Auto-generated method stub

		Query myQuery = this.entityManager
				.createQuery("UPDATE Producto p SET p.cantidad = p.cantidad-1 WHERE p.codigoBarras = :datoCodigo");
		myQuery.setParameter("datoCodigo", codigoBarras);

		return myQuery.executeUpdate();
	}

}
