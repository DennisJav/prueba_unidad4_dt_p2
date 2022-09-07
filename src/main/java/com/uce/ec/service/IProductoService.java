package com.uce.ec.service;

import java.util.List;

import com.uce.ec.modelo.Producto;


public interface IProductoService {
	void insertarProducto(Producto producto);
	Producto buscarProductoCodigo(String codigoBarras);
	void actualizarProducto(Producto producto);
	List<Producto> buscarProductosTodos();
}
