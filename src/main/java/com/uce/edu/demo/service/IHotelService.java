package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelService {

	public List<Hotel> busacarHotelInnerJoin(String tipoHabitacion);

	public List<Hotel> busacarHotelInnerJoin();

	public List<Hotel> busacarHotelOuterJoinRight(String tipoHabitacion);

	public List<Hotel> busacarHotelOuterJoinLeft(String tipoHabitacion);

	public List<Hotel> busacarHotelOuterJoinLeft();

	public List<Hotel> busacarHotelOuterJoinFull(String tipoHabitacion);

	public List<Hotel> busacarHotelJoinWhere(String tipoHabitacion);

	public List<Hotel> busacarHotelJoinFetch(String tipoHabitacion);

}