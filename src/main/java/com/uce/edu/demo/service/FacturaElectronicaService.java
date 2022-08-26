package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleRepository;
import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.modelo.FacturaElectronicaSupermaxi;

@Service
public class FacturaElectronicaService implements IFacturaElectronicaService{

	@Autowired
	private IFacturaElectronicaRepository iFacturaElectronicaRepository;

	
	
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(FacturaElectronicaSupermaxi facturaElectronica) {
		// TODO Auto-generated method stub
		this.iFacturaElectronicaRepository.insertar(facturaElectronica);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void procesarElectronica(String numeroFactura, Integer cantidadItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronicaSupermaxi fe = new FacturaElectronicaSupermaxi();
		
		fe.setFecha(LocalDateTime.now());
		fe.setMonto(monto);
		fe.setNumero(numeroFactura);
		fe.setNumeroItems(cantidadItems);
		
		this.iFacturaElectronicaRepository.insertar(fe);

		
		throw new RuntimeException();
	}

}
