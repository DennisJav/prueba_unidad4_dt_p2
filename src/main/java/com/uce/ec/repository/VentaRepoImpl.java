package com.uce.ec.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.Venta;
import com.uce.ec.modelo.VentaTO;

@Repository
@Transactional
public class VentaRepoImpl implements IVentaRepo{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertarVenta(Venta venta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(venta);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Venta> buscarFechaVenta(String fechaVenta) {
		// TODO Auto-generated method stub
		TypedQuery<Venta> myQuery = this.entityManager.createQuery(
				"SELECT v FROM Venta v JOIN FETCH v.detalles v WHERE v.fecha = :valor", Venta.class);
		myQuery.setParameter("valor", fechaVenta);
		return myQuery.getResultList();
	}

	@Override
	public List<VentaTO> buscarVentaSencilla(LocalDateTime fechaVenta, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
}
