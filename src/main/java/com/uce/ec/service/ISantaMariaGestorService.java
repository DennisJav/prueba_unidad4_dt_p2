package com.uce.ec.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.ec.modelo.Producto;
import com.uce.ec.modelo.ProductoVenta;

public interface ISantaMariaGestorService {

	void ingresarProducto(String codigoBarras, String nombre, String categoria, Integer stock, BigDecimal precio);
	void realizarVenta(List<ProductoVenta> productos, String cedula, String numeroVenta);
	void reporteVentas(LocalDateTime fechaVenta, String categoria, Integer cantidad);
	
}
