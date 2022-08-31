package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tienpoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre del Hilo: "+ Thread.currentThread().getName());
		Cajero cajero1 = new Cajero("Edison", Arrays.asList("Pepito"));
		
		Cajero cajero2 = new Cajero("Julian", Arrays.asList("Alberto"));
		
		Cajero cajero3 = new Cajero("Andres", Arrays.asList("Josue"));
		
		
		PCCajero gestorAtencion = new PCCajero();
		
		gestorAtencion.procesar(cajero1);
		
		PCCajero gestorAtencion2 = new PCCajero();
		
		gestorAtencion2.procesar(cajero2);
		
		PCCajero gestorAtencion3 = new PCCajero();
		gestorAtencion3.procesar(cajero3);
		
		
		
		long tienpoFinal = System.currentTimeMillis();
		
		
		long tiempoTranscurrido = (tienpoFinal-tienpoInicial)/1000;
		
		System.out.println("Tiempo Transcurrido: " + tiempoTranscurrido +" seg");
		
	}

}
