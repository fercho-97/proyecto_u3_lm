package com.uce.edu.demo.service;

import java.util.List;

public interface IGestorService {

	//public Integer crearFacturaDetalles(String cedulaCliente, String numeroFactura, List<String> codigos);

	//public void actualizarStock(String codigoBarras);

	//public void crearFacturaElectronica(String numeroFactura, Integer items);
	
	public void realizarCompra(String cedulaCliente, String numeroFactura, List<String> codigos);

}
