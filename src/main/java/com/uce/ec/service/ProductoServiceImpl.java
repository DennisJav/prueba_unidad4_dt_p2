package com.uce.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.Producto;
import com.uce.ec.repository.IProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepo productoRepo;
	
	@Override
	public void insertarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.insertarProducto(producto);
	}

	@Override
	public Producto buscarProductoCodigo(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarProductoCodigo(codigoBarras);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.actualizarProducto(producto);
	}

	@Override
	public List<Producto> buscarProductosTodos() {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarProductosTodos();
	}
	

}
