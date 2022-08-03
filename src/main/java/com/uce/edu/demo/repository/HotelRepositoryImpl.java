package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> busacarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :datoTipoHabitacion", Hotel.class);
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> busacarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha", Hotel.class);
		

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
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha", Hotel.class);
	
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
		return null;
	}

	@Override
	public List<Hotel> busacarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
