package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3LmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU3LmApplication.class);

	@Autowired
	private IHotelService iHotelService;



	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3LmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		LOG.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listaHotel = this.iHotelService.busacarHotelInnerJoin("Familiar");

		for (Hotel h : listaHotel) {

			LOG.info("Hotel LAZY: " + h.getNombre() + h.getDireccion());
			for (Habitacion ha : h.getHabitaciones()) {
				LOG.info("Habitaciones: " + ha);
			}
		}

		LOG.info("REALCIONAMIENTO WHERE");

		List<Hotel> listaHotelWhere = this.iHotelService.busacarHotelJoinWhere("Familiar");

		for (Hotel h : listaHotelWhere) {

			LOG.info("Hotel Where: " + h.getNombre() + h.getDireccion());

		}

		LOG.info("JOIN FETCH");

		List<Hotel> listaHotelFetch = this.iHotelService.busacarHotelJoinFetch("Familiar");

		for (Hotel h : listaHotelFetch) {

			LOG.info("Hotel FETCH: " + h.getNombre() + h.getDireccion());
			for (Habitacion ha : h.getHabitaciones()) {
				LOG.info("Habitaciones Fetch: " + ha);
			}

		}

		
	}

}
