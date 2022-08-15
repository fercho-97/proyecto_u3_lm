package com.uce.edu.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.transaction.Transactional;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.modelo.Hotel;

@SpringBootTest
class HotelRepositoryImplTest {

	private static Logger LOG = Logger.getLogger(HotelRepositoryImplTest.class);

	@Autowired
	private IHotelRepository iHotelRepository;

	@BeforeAll
	public static void beforeClass() throws Exception {

		LOG.info("Inicia la prueba");

	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {

		LOG.info("Termina la prueba");

	}

	@BeforeEach
	public void setUp() throws Exception {

		LOG.info("Inicia la prueba del metodo");

	}

	@AfterEach
	void tearDown() throws Exception {

		LOG.info("Termina la prueba del metodo");
	}

	@Test
	@Order(1)
	public void testInsertar() {

		Hotel h = new Hotel();
		h.setDireccion("Av. Quintana");
		h.setNombre("Imperial");

		this.iHotelRepository.insertar(h);
		assertNotNull(this.iHotelRepository.buscar(h.getId()));
	}

	@Test
	@Order(2)
	public void testBuscar() {
		LOG.info("Test buscar hotel con id 2");
		Integer id = 2;
		Hotel h = this.iHotelRepository.buscar(id);

		assertThat(h.getId()).isEqualTo(id);
	}

	@Test
	@Order(4)
	public void testActualizar() {

		LOG.info("Test Actualzar hotel con id 10");
		Integer id = 10;
		String nombre = "ZEUS";

		Hotel h = new Hotel();
		h.setNombre(nombre);
		h.setDireccion("Conocoto");
		h.setId(id);

		Hotel hotelActualizado = this.iHotelRepository.actualizar(h);

		assertThat(hotelActualizado.getNombre()).isEqualTo(nombre);

	}

	@Test
	@Transactional
	@Rollback(true)
	@Order(3)
	public void testBorrar() {

		LOG.info("Test Borrar hotel con id 13");
		Integer id = 13;

		this.iHotelRepository.borrar(id);

		assertNull(this.iHotelRepository.buscar(id));

	}
	
	@Test
	@Order(5)
	public void testListarHoteles() {
		LOG.info("Listar todos los hoteles");
		
		List<Hotel> listaHoteles = this.iHotelRepository.listar();
		
		for(Hotel h : listaHoteles) {
			
			LOG.info(h);
		}
		

		assertThat(listaHoteles).size().isGreaterThan(0);
	}

	

}
