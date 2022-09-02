package com.uce.edu.demo.hilos.paralelo;

import java.util.List;

public class SurtidorParalelo {

	private String nombre;

	private List<String> vehiculos;

	public SurtidorParalelo(String nombre, List<String> vehiculos) {
		super();
		this.nombre = nombre;
		this.vehiculos = vehiculos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<String> vehiculos) {
		this.vehiculos = vehiculos;
	}

}


