package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.repository.modelo.FacturaSupermaxi;

public interface IFacturaSupermaxiService {

	public void insertar(FacturaSupermaxi factura);
	
	public void actulizar(FacturaSupermaxi factura);
	
	public FacturaSupermaxi buscarPorNumero(String numero);
	

	public BigDecimal procesarFactura(String cedulaCliente, String numeroFactura, List<String> codigoBarras);

	
}
