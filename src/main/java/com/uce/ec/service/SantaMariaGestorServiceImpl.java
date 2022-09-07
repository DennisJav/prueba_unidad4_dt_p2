package com.uce.ec.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.DetalleVenta;
import com.uce.ec.modelo.Producto;
import com.uce.ec.modelo.ProductoVenta;
import com.uce.ec.modelo.Venta;
import com.uce.ec.repository.IProductoRepo;
import com.uce.ec.repository.IVentaRepo;

@Service
public class SantaMariaGestorServiceImpl implements ISantaMariaGestorService{

	@Autowired
	private IProductoRepo productoService;
	
	@Autowired
	private IVentaRepo ventaService;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void ingresarProducto(String codigoBarras, String nombre, String categoria, Integer stock,
			BigDecimal precio) {
		// TODO Auto-generated method stub
		
		List<Producto> listaProductos = this.productoService.buscarProductosTodos();
		boolean flag=false;

		for(Producto prod:listaProductos) {
			if(prod.getCodigoBarras().equals(codigoBarras)) {
				flag=true;
			}
		}
		if(flag==false) {
			System.out.println("entro false");
			Producto p=new Producto();
			p.setNombre(nombre);
			p.setCodigoBarras(codigoBarras);
			p.setCategoria(categoria);
			p.setPrecio(precio);
			p.setStock(stock);
			this.productoService.insertarProducto(p);
		}else {
			Producto productoBuscado=this.productoService.buscarProductoCodigo(codigoBarras);
			System.out.println("Enconro");
			productoBuscado.setStock(productoBuscado.getStock()+stock);
			this.productoService.actualizarProducto(productoBuscado);
		}	
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarVenta(List<ProductoVenta> productos, String cedula, String numeroVenta) {
		// TODO Auto-generated method stub
		
		Venta venta=new Venta();
		venta.setCedulaCliente(cedula);
		venta.setFecha(LocalDateTime.now());
		venta.setNumero(numeroVenta);
		
		List<DetalleVenta> listaDeta = new ArrayList<>();
		DetalleVenta deta=new DetalleVenta();
		BigDecimal valorTotal=BigDecimal.ZERO;
		boolean flag=false;
		for(ProductoVenta prod:productos) {
			Producto p=this.productoService.buscarProductoCodigo(prod.getCodigoBarras());
			if(prod.getCantidad() < p.getStock()) {
				System.out.println("entro if for");
				flag=true;
				p.setStock(p.getStock()-prod.getCantidad());
				this.productoService.actualizarProducto(p);
				deta.setProducto(p);
				deta.setCantidad(prod.getCantidad());
				deta.setPrecioUnidad(p.getPrecio());
				BigDecimal subtotal = BigDecimal.valueOf(prod.getCantidad()).multiply(p.getPrecio());
				deta.setSubtotal(subtotal);
				valorTotal=valorTotal.add(subtotal);	
				deta.setVenta(venta);
				listaDeta.add(deta);
				
			}else {
				throw new RuntimeException();
			}
			
		}
		if(flag==true) {
			venta.setTotalVenta(valorTotal);
			venta.setDetalles(listaDeta);
			this.ventaService.insertarVenta(venta);
		}
		
	}

	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void reporteVentas(LocalDateTime fechaVenta, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		
		
		
	}




	
	
}
