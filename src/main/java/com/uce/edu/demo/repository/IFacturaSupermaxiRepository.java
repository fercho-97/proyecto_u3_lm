package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.FacturaSupermaxi;

public interface IFacturaSupermaxiRepository {

	public void insertar (FacturaSupermaxi factura);
	
	public void actualizar (FacturaSupermaxi factura);
	
	public FacturaSupermaxi buscarPorNumero (String numero);
	
}
