package com.uce.ec;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.ec.modelo.ProductoVenta;
import com.uce.ec.service.ISantaMariaGestorService;

@SpringBootApplication
public class PruebaUnidad4DtP21Application implements CommandLineRunner {
	@Autowired
	private ISantaMariaGestorService santaMariaGestorService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad4DtP21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	//	this.santaMariaGestorService.ingresarProducto("3", "deja", "aseo", 5, new BigDecimal(2.00));

		ProductoVenta prod = new ProductoVenta();
		prod.setCantidad(1);
		prod.setCodigoBarras("3");

		List<ProductoVenta> venta = new ArrayList<>();
		venta.add(prod);

		//this.santaMariaGestorService.realizarVenta(venta, "123", "001");

	}

}
