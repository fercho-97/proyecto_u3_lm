package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura_electronica")
public class FacturaElectronicaSupermaxi {

	@Id
	@Column(name = "fact_elec_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fact_elec_id_seq")
	@SequenceGenerator(name = "fact_elec_id_seq", sequenceName = "fact_elec_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "fact_elec_numero")
	private String numero;

	@Column(name = "fact_elec_fecha")
	private LocalDateTime fecha;

	@Column(name = "fact_elec_monto")
	private BigDecimal monto;

	@Column(name = "fact_elec_numero_items")
	private Integer numeroItems;

	@Override
	public String toString() {
		return "FacturaElectronicaSupermaxi [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", monto=" + monto
				+ ", numeroItems=" + numeroItems + "]";
	}

	// SET Y GET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Integer getNumeroItems() {
		return numeroItems;
	}

	public void setNumeroItems(Integer numeroItems) {
		this.numeroItems = numeroItems;
	}

}
