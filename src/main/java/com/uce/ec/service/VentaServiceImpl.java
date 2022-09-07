package com.uce.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.Venta;
import com.uce.ec.repository.IVentaRepo;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaRepo ventaRepo;
	
	@Override
	public void insertarVenta(Venta venta) {
		// TODO Auto-generated method stub
		this.ventaRepo.insertarVenta(venta);
	}

	@Override
	public List<Venta> buscarFechaVenta(String fechaVenta) {
		// TODO Auto-generated method stub
		return this.ventaRepo.buscarFechaVenta(fechaVenta);
	}

	
}
