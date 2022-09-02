package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainVehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tienpoInicial = System.currentTimeMillis();

		System.out.println("Nombre del Hilo: " + Thread.currentThread().getName());
		
		SurtidorParalelo surtidor1 = new SurtidorParalelo("Juanito",  Arrays.asList("Versa","Hilux","Dmax","Sonata"));
		
		SurtidorParalelo surtidor2 = new SurtidorParalelo("Jaime",  Arrays.asList("Aveo","CSM","Tigo 7","Sonata"));
		
		SurtidorParalelo surtidor3 = new SurtidorParalelo("Carlos",  Arrays.asList("Baic","Sail"));
		
		SurtidorParalelo surtidor4 = new SurtidorParalelo("Ximena",  Arrays.asList("Cruce","Cadillac"));
		
		SurtidorParalelo surtidor5 = new SurtidorParalelo("Angelica",  Arrays.asList("Onix","Camaro","Grand Vitara"));
		
		
		
		PCBombaParalelo atencion1 = new PCBombaParalelo(surtidor1);
		atencion1.start();
		
		PCBombaParalelo atencion2 = new PCBombaParalelo(surtidor2);
		atencion2.start();
		
		PCBombaParalelo atencion3 = new PCBombaParalelo(surtidor3);
		atencion3.start();
		
		PCBombaParalelo atencion4 = new PCBombaParalelo(surtidor4);
		atencion4.start();
		
		PCBombaParalelo atencion5 = new PCBombaParalelo(surtidor5);
		atencion5.start();
		
	}

}
