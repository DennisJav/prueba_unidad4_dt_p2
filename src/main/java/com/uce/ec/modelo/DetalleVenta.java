package com.uce.ec.modelo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
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
@Table(name = "detalle_venta")
public class DetalleVenta {

	@Id
	@Column(name = "deta_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deta_id_seq")
	@SequenceGenerator(name = "deta_id_seq", sequenceName = "deta_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "deta_cantidad")
	private Integer cantidad;

	@Column(name = "deta_precioUnidad")
	private BigDecimal precioUnidad;
	
	@Column(name = "deta_subtotal")
	private BigDecimal subtotal;
	
	
	
	@ManyToOne
	@JoinColumn(name = "deta_vent_id")
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "deta_prod_id")
	private Producto producto;

	
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

	public BigDecimal getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(BigDecimal precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	
	
}
