package com.uce.edu.demo.service.funcional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.print.attribute.HashDocAttributeSet;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static boolean prueba(Integer numero) {

		boolean valida = numero >= 3;
		return valida;
	}

	public static boolean validacion(String palabra) {

		boolean valida = palabra.length() >= 12;
		return valida;
	}

	public static Integer obtenerCantidadLetras(String palabra) {

		Integer cantidad = palabra.length();
		return cantidad;
	}

	public static void imprimir(String cadena) {

		System.out.println(cadena);
	}

	public static void guardar(String elementoAInsertar) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Java
	
		LOG.info("Supplier se genero una lista");
		Stream<Integer> testNumeros = Stream.generate(() -> 2).limit(8);

		LOG.info("Consumer");
		testNumeros.forEach(valor -> System.out.println(valor));

		LOG.info("Predicate");

		List<String> equipos = Arrays.asList("Bayer Munich", "Real Madrid", "Juventus", "Sevilla", "PSG");

		Stream<String> equiposFiltro = equipos.stream().filter(a -> validacion(a));
		equiposFiltro.forEach(cadena -> System.out.println(cadena));

		LOG.info("Function");

		Stream<Integer> numeros = equipos.stream().map(f -> obtenerCantidadLetras(f));
		numeros.forEach(valor -> System.out.println(valor));

	}

}
