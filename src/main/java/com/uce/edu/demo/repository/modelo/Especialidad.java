package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "especialidad")
public class Especialidad {

	@Id
	@Column(name = "espe_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "espe_id_seq")
	@SequenceGenerator(name = "espe_id_seq", sequenceName = "espe_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "espe_nombre")
	private String nombre;

	@Column(name = "espe_codigo")
	private String codigo;

	@ManyToOne
	@JoinColumn(name = "espe_id_doctor")
	private Doctor doctor;

	@Override
	public String toString() {
		return "Especialidad [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", doctor=" + doctor + "]";
	}

	// SET Y GET
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
