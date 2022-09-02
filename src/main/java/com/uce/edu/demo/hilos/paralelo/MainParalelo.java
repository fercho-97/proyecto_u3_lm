package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tienpoInicial = System.currentTimeMillis();

		System.out.println("Nombre del Hilo: " + Thread.currentThread().getName());
		CajeroParalelo cajero1 = new CajeroParalelo("Edison", Arrays.asList("Pepito"));

		CajeroParalelo cajero2 = new CajeroParalelo("Julian", Arrays.asList("Alberto"));

		CajeroParalelo cajero3 = new CajeroParalelo("Andres", Arrays.asList("Josue"));

		CajeroParalelo cajero4 = new CajeroParalelo("Edison", Arrays.asList("Pepito"));

		CajeroParalelo cajero5 = new CajeroParalelo("Edison", Arrays.asList("Pepito"));
		CajeroParalelo cajero6 = new CajeroParalelo("Edison", Arrays.asList("Pepito"));

		
		
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start();

		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start();

		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start();
		
		
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero4);
		gestorAtencion4.start();

		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero5);
		gestorAtencion5.start();

		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
		gestorAtencion6.start();
		
		

		long tienpoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tienpoFinal - tienpoInicial) / 1000;

		System.out.println("Tiempo Transcurrido Main Paralelo: " + tiempoTranscurrido + " seg");

	}

}
