package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread {

	private CajeroParalelo cajeroParalelo;

	public PCCajeroParalelo(CajeroParalelo cajeroParalelo) {
		this.cajeroParalelo = cajeroParalelo;

	}

	// Disparar el metodo a apralelizar
	@Override
	public void run() {
		this.procesar(this.cajeroParalelo);
	}

	public void procesar(CajeroParalelo cajero) {
		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre del Hilo procesar(paralelo): " + Thread.currentThread().getName());
		System.out.println("Procesando cjaero: " + cajero.getNombre());
		for (String cliente : cajero.getClientes()) {
			this.atenderCliente(cliente);
		}

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("Tiempo Transcurrido en hilo paralelo " + cajero.getNombre() + " " + tiempoTranscurrido + " seg");

	}

	public void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
