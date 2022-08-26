package com.uce.edu.demo.service;

import java.math.BigDecimal;

import com.uce.edu.demo.repository.modelo.FacturaElectronicaSupermaxi;

public interface IFacturaElectronicaService {

	public void insertar(FacturaElectronicaSupermaxi facturaElectronica);

	public void procesarElectronica(String numeroFactura, Integer cantidadItems, BigDecimal monto);
}
