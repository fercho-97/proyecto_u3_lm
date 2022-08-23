package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.uce.edu.demo.service.IGestorService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3LmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU3LmApplication.class);

	@Autowired
	private IFacturaService iFacturaService;
	
	@Autowired
	private IHotelService iHotelService;
	
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	private IGestorService iGestorService;
	

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3LmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		List<String> listaCompras = new ArrayList<String>();
		
		listaCompras.add("a7b7");
		listaCompras.add("a6b6");
		listaCompras.add("a8b8");
		listaCompras.add("a1b1");
		

		
		this.iGestorService.crearFacturaDetalles("003", "8", listaCompras);
		
	}

}
