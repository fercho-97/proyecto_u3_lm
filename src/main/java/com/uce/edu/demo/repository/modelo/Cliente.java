package com.uce.edu.demo.repository.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "cliente_supermaxi")
public class Cliente {

	@Id
	@Column(name = "clie_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_id_seq")
	@SequenceGenerator(name = "clie_id_seq", sequenceName = "clie_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "clie_super_nombre")
	private String nombre;

	@Column(name = "clie_super_cedula")
	private String numeroCedula;
	
	@Column(name = "clie_super_numero_tarjeta")
	private String numeroTarjeta;
	
	@OneToMany(mappedBy = "cliente")
	private List<FacturaSupermaxi> facturas;

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", numeroCedula=" + numeroCedula + ", facturas=" + facturas
				+ "]";
	}
	
	
	//SET Y GET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroCedula() {
		return numeroCedula;
	}

	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
	}

	public List<FacturaSupermaxi> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaSupermaxi> facturas) {
		this.facturas = facturas;
	}
	
	
	
}
