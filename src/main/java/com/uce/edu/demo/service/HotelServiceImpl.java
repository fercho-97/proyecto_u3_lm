package com.uce.edu.demo.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.ProyectoU3LmApplication;
import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{

	private static Logger LOG = Logger.getLogger(ProyectoU3LmApplication.class);
	
	@Autowired
	private IHotelRepository iHotelRepository;
	
	@Override
	public List<Hotel> busacarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.busacarHotelInnerJoin(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> busacarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.busacarHotelInnerJoin();
	}

	@Override
	public List<Hotel> busacarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.busacarHotelOuterJoinRight(tipoHabitacion);
	}

	@Override
	public List<Hotel> busacarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.busacarHotelOuterJoinLeft(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> busacarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.busacarHotelOuterJoinLeft();
	}

	@Override
	public List<Hotel> busacarHotelOuterJoinFull(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Hotel> busacarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.busacarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> busacarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa service: "  + TransactionSynchronizationManager.isActualTransactionActive());
		return this.iHotelRepository.busacarHotelJoinFetch(tipoHabitacion);
	}

}
