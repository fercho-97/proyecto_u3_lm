package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
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

		LOG.info("INNER JOIN");
		List<Hotel> listaHotel = this.iHotelService.busacarHotelInnerJoin("Familiar");

		for (Hotel h : listaHotel) {

			LOG.info("Hotel Familiar Inner: " + h.getNombre() + "" + h.getDireccion());
		}
		
		List<Hotel> listaHotelInner = this.iHotelService.busacarHotelInnerJoin();

		for (Hotel h : listaHotelInner) {

			LOG.info("Hotel Inner: " + h.getNombre() + "" + h.getDireccion());
		}


		
		LOG.info("LEFT JOIN");
		// LEFT
		List<Hotel> listaHotel2 = this.iHotelService.busacarHotelOuterJoinLeft("Familiar");

		for (Hotel h : listaHotel2) {

			LOG.info("Hotel Familiar Left: " + h.getNombre() + "" + h.getDireccion());
		}
		
		List<Hotel> listaHotelLeft = this.iHotelService.busacarHotelOuterJoinLeft();

		for (Hotel h : listaHotelLeft) {

			LOG.info("Hotel Left: " + h.getNombre() + "" + h.getDireccion());
		}

		LOG.info("Right JOIN");
		//Right
		List<Hotel> listaHotel3 = this.iHotelService.busacarHotelOuterJoinRight("Familiar");

		for (Hotel h : listaHotel3) {

			LOG.info("Hotel Familiar Right: " + h.getNombre() + "" + h.getDireccion());
		}

	}

}
