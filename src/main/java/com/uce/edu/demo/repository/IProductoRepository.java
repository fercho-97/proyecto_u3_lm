package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepository {

	
	public Producto buscarCodigoBarras(String codigoBarras);
	
	public int actulizarStock(String codigoBarras);
	
}
