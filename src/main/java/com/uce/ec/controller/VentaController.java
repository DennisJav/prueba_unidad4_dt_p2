package com.uce.ec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.modelmbean.ModelMBeanOperationInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.ec.modelo.DetalleVenta;
import com.uce.ec.modelo.Producto;
import com.uce.ec.modelo.ProductoVenta;
import com.uce.ec.modelo.Venta;
import com.uce.ec.service.IProductoService;
import com.uce.ec.service.ISantaMariaGestorService;

@Controller
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	private ISantaMariaGestorService santaMariaGestorService;

	@Autowired
	private IProductoService productoService;
	
	
	@GetMapping("/productos")
	public String mostrarTodosProductos(Model modelo) {
		
		List<Producto> lista = this.productoService.buscarProductosTodos();
		modelo.addAttribute("productos", lista);
		
		return "vistaProductos";
	}
	
	// 1
	
	@PostMapping("/insertarProducto")
	public String insertarProducto(Producto producto) {

		this.santaMariaGestorService.ingresarProducto(producto.getCodigoBarras(), producto.getNombre(),
				producto.getCategoria(), producto.getStock(), producto.getPrecio());

		return "redirect:/ventas/productos";
	}

	@GetMapping("/nuevoProducto")
	public String vistaNuevoProducto(Producto producto) {

		return "vistaProductoNuevo";
	}

	//2
	@PostMapping("/realizarVenta")
	public String realizarVenta(DetalleVenta deVenta) {
		
		ProductoVenta prod = new ProductoVenta();
		prod.setCantidad(deVenta.getCantidad());
		prod.setCodigoBarras(deVenta.getProducto().getCodigoBarras());

		List<ProductoVenta> listaVenta = new ArrayList<>();
		listaVenta.add(prod);

		
		this.santaMariaGestorService.realizarVenta(listaVenta, deVenta.getVenta().getCedulaCliente(), deVenta.getVenta().getNumero());
		
		return "redirect:/ventas/productos";
	}
	
	
	@GetMapping("/nuevaVenta")
	public String vistaVentaNueva(DetalleVenta deVenta) {
		
		return "vistaVentaNueva";
	}
	
	//3
	

	
	
	//4
	@GetMapping("/resultado")
	public String mostrarStockProducto(Producto producto, Model modelo) {
		
		Producto prod = this.productoService.buscarProductoCodigo(producto.getCodigoBarras());
		modelo.addAttribute("prod", prod);
		
		return "listaStock";
	}
	
	
	@GetMapping("/buscar")
	public String vistaStock(Producto producto) {

		return "vistaBuscarCodigo";
	}
	
}
