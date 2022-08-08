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
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3LmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		LOG.info("INNER JOIN");
		List<Factura> listaFactura = this.iFacturaService.buscarFacturaInnerJoin(4);

		for (Factura f : listaFactura) {

			LOG.info("Factura Inner: " + "Numero: " + f.getNumero() + "  Fecha: " + f.getFecha());
		}

		List<Factura> listaFacturaInner = this.iFacturaService.buscarFacturaInnerJoin();

		for (Factura f : listaFacturaInner) {

			LOG.info("Factura Inner simple: " + "Numero: " + f.getNumero() + "  Fecha: " + f.getFecha());
		}

		// LEFT
		LOG.info("LEFT JOIN");
		List<Factura> listaFactura2 = this.iFacturaService.buscarFacturaOuterJoinLeft(4);

		for (Factura f : listaFactura2) {

			LOG.info("Factura Left: " + "Numero: " + f.getNumero() + "  Fecha: " + f.getFecha());
		}

		List<Factura> listaFacturalLeft = this.iFacturaService.buscarFacturalOuterJoinLeft();

		for (Factura f : listaFacturalLeft) {

			LOG.info("Factura Left simple: " + "Numero: " + f.getNumero() + "  Fecha: " + f.getFecha());
		}

		// Right 
		LOG.info("Right JOIN"); 
		List<Factura> listaFactura3 =this.iFacturaService.buscarFacturalOuterJoinRight(4);

		for (Factura f : listaFactura3) {

			LOG.info("Factura Right: " + "Numero: " + f.getNumero() + "  Fecha: " + f.getFecha());
		}

	}

}
