package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelRepository {

	public List<Hotel> busacarHotelInnerJoin(String tipoHabitacion);
	
	public List<Hotel> busacarHotelInnerJoin();
	
	public List<Hotel> busacarHotelOuterJoinRight(String tipoHabitacion);
	
	public List<Hotel> busacarHotelOuterJoinLeft(String tipoHabitacion);
	
	public List<Hotel> busacarHotelOuterJoinLeft();
	
	public List<Hotel> busacarHotelOuterJoinFull(String tipoHabitacion);
	
	public List<Hotel> busacarHotelJoinWhere(String tipoHabitacion);
	
	public List<Hotel> busacarHotelJoinFetch(String tipoHabitacion);
	
	
	
	public void insertar(Hotel hotel);

	public Hotel buscar(Integer id);

	public Hotel actualizar(Hotel hotel);

	public void borrar(Integer id);
	
	public List<Hotel> listar();
	
}