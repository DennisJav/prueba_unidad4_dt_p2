package com.uce.ec.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.ec.modelo.Producto;


public interface IProductoRepo {

	void insertarProducto(Producto producto);
	Producto buscarProductoCodigo(String codigoBarras);
	void actualizarProducto(Producto producto);
	List<Producto> buscarProductosTodos();
	
	
}
