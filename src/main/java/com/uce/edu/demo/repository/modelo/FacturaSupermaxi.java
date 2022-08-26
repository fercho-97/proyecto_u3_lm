package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "factura_supermaxi")
public class FacturaSupermaxi {

	@Id
	@Column(name = "fact_super_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fact_super_id_seq")
	@SequenceGenerator(name = "fact_super_id_seq", sequenceName = "fact_super_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "fact_super_fecha")
	private LocalDateTime fecha;

	@Column(name = "fact_super_numero")
	private String numero;

	@Column(name = "fact_super_monto")
	private BigDecimal monto;

	@ManyToOne
	@JoinColumn(name = "fact_super_id_clie")
	private Cliente cliente;

	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Detalle> detalles;

	@Override
	public String toString() {
		return "FacturaSupermaxi [id=" + id + ", fecha=" + fecha + ", numero=" + numero + ", monto=" + monto
				+ ", cliente=" + cliente + ", detalles=" + detalles + "]";
	}

	//SET Y GET
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	
	
}
