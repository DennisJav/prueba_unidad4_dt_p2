package com.uce.ec.modelo;

import java.math.BigDecimal;

public class VentaTO {

	private String codigoBarras;
	private String categoria;
	private Integer cantidad;
	private BigDecimal precio;
	private BigDecimal subTotal;
	
	
	
	
	
	
	public VentaTO() {
		
	}
	
	public VentaTO(String codigoBarras, String categoria, Integer cantidad, BigDecimal precio, BigDecimal subTotal) {
		super();
		this.codigoBarras = codigoBarras;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precio = precio;
		this.subTotal = subTotal;
	}
	
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	
	
	
	
}
