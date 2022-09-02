package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCBombaParalelo extends Thread{

	private SurtidorParalelo surtidorParalelo;
	
	public PCBombaParalelo(SurtidorParalelo surtidorParalelo) {
		this.surtidorParalelo = surtidorParalelo;
	}
	
	
	@Override
	public void run() {
		this.procesar(this.surtidorParalelo);
	}
	
	
	public void procesar(SurtidorParalelo surtidorParalelo) {
		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre del Hilo procesar(paralelo): " + Thread.currentThread().getName());
		System.out.println("Procesando surtidor: " + surtidorParalelo.getNombre());
		for (String cliente : surtidorParalelo.getVehiculos()) {
			this.atenderCliente(cliente);
		}

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("Tiempo Transcurrido en hilo paralelo " + surtidorParalelo.getNombre() + " " + tiempoTranscurrido + " seg");

	}
	
	
	public void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);

		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
