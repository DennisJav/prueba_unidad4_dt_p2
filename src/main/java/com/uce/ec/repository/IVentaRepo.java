package com.uce.ec.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.ec.modelo.Venta;
import com.uce.ec.modelo.VentaTO;

public interface IVentaRepo {

	void insertarVenta(Venta venta);
	List<Venta> buscarFechaVenta(String fechaVenta);
	List<VentaTO> buscarVentaSencilla(LocalDateTime fechaVenta, String categoria, Integer cantidad );
	
}
