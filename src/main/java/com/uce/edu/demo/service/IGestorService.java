package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

public interface IGestorService {

	public void crearFacturaDetalles(String cedulaCliente, String numeroFactura, List<String> codigos);

	public void actualizarStock(String codigoBarras);

	public void crearFacturaElectronica(String numeroFactura, BigDecimal monto, Integer items);
}
