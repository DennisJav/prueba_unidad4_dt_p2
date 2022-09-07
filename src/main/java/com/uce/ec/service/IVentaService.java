package com.uce.ec.service;

import java.util.List;

import com.uce.ec.modelo.Venta;

public interface IVentaService {
	void insertarVenta(Venta venta);
	List<Venta> buscarFechaVenta(String fechaVenta);
}
