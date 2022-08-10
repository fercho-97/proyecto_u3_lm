package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.ProyectoU3LmApplication;
import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	private static Logger LOG = Logger.getLogger(ProyectoU3LmApplication.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> busacarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :datoTipoHabitacion", Hotel.class);
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);

		List<Hotel> hotels = myQuery.getResultList();
		for(Hotel h : hotels) {
			h.getHabitaciones().size();
			
		}
		
		return hotels;
	}

	@Override
	public List<Hotel> busacarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha",
				Hotel.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> busacarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo = :datoTipoHabitacion", Hotel.class);
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> busacarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",
				Hotel.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> busacarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo = :datoTipoHabitacion", Hotel.class);
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);

		return myQuery.getResultList();
		
		
		
	}

	@Override
	public List<Hotel> busacarHotelOuterJoinFull(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> busacarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub

		// SELECT * FROM hotel h, habitacion ha WHERE h.hotl_id = ha.habi_id_hotel-->en la DB
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel AND ha.tipo = :datoTipoHabitacion", Hotel.class);
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);


		return myQuery.getResultList();
	}

	@Override
	//@Transactional(value = TxType.MANDATORY)
	public List<Hotel> busacarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		
		LOG.info("Transaccion activa repository: "  + TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo = :datoTipoHabitacion", Hotel.class);
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);
		
		return myQuery.getResultList();
	}

}
