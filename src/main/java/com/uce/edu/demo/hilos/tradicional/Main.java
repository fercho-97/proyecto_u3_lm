package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tienpoInicial = System.currentTimeMillis();
		
		Cajero cajero1 = new Cajero("Edison", Arrays.asList("Pepito","Juan","Daniela","Pedro"));
		
		
		Cajero cajero2 = new Cajero("Julian", Arrays.asList("Alberto","Edison","Luis"));
		
		
		Cajero cajero3 = new Cajero("Andres", Arrays.asList("Josue","Daniel"));
		
		
		PCCajero gestorAtencion = new PCCajero();
		
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		
		long tienpoFinal = System.currentTimeMillis();
		
		
		long tiempoTranscurrido = (tienpoFinal-tienpoInicial)/1000;
		
		System.out.println("Tiempo Transcurrido: " + tiempoTranscurrido +" seg");
		
	}

}
