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
@Table(name = "doctor")
public class Doctor {

	@Id
	@Column(name = "doct_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doct_id_seq")
	@SequenceGenerator(name = "doct_id_seq", sequenceName = "doct_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "doct_nombre")
	private String nombre;

	@Column(name = "doct_apellido")
	private String apellido;

	@Column(name = "doct_cedula")
	private String cedula;

	@OneToMany(mappedBy = "doctor")
	private List<Especialidad> especialidad;

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", especialidad=" + especialidad + "]";
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<Especialidad> getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(List<Especialidad> especialidad) {
		this.especialidad = especialidad;
	}

}
