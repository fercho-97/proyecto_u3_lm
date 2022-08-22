package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

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
@Table(name = "detalle_fsupermaxi")
public class Detalle {

	@Id
	@Column(name = "deta_fsupermaxi_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deta_fsupermaxi_id")
	@SequenceGenerator(name = "deta_fsupermaxi_id", sequenceName = "deta_fsupermaxi_id", allocationSize = 1)
	private Integer id;

	@Column(name = "deta_fsupermaxi_cantidad")
	private Integer cantidad;

	@Column(name = "deta_fsupermaxi_subtotal")
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name = "deta_fsupermaxi_id_fact")
	private FacturaSupermaxi factura;
	
	@ManyToOne
	@JoinColumn(name = "deta_fsupermaxi_id_prod")
	private Producto producto;

	@Override
	public String toString() {
		return "Detalle [id=" + id + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", factura=" + factura
				+ ", producto=" + producto + "]";
	}
	
	//SET Y GET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public FacturaSupermaxi getFactura() {
		return factura;
	}

	public void setFactura(FacturaSupermaxi factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
