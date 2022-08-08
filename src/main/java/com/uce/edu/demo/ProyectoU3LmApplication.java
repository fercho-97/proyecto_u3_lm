package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.DetalleFactura;
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

		LOG.info("INNER JOIN EAGER/LAZY");
		List<Factura> listaFactura = this.iFacturaService.buscarFacturaInnerJoin(8);

		for (Factura f : listaFactura) {

			LOG.info(" LAZY   " + "Numero: " + f.getNumero() + "  Fecha: " + f.getFecha());
			for (DetalleFactura df : f.getDetalleFacturas()) {
				LOG.info("Detalle Factura: " + df);
			}
		}

		LOG.info("REALCIONAMIENTO WHERE");

		List<Factura> listaFacturaWhere = this.iFacturaService.busacarFacturaJoinWhere(8);

		for (Factura f : listaFacturaWhere) {

			LOG.info("Factura Where: " + "Numero: " + f.getNumero() + "  Fecha: " + f.getFecha());

		}

		LOG.info("JOIN FETCH");

		List<Factura> listaFacturaFetch = this.iFacturaService.busacarFacturaJoinFetch(8);

		for (Factura f : listaFacturaFetch) {

			LOG.info("Factura FETCH: " + "Numero: " + f.getNumero() + "  Fecha: " + f.getFecha());
			for (DetalleFactura d : f.getDetalleFacturas()) {
				LOG.info("Detalles Fetch: " + d);
			}

		}

	}

}
