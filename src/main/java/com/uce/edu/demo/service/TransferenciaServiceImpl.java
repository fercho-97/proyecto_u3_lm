package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransfereciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;
	
	@Autowired
	private ITransfereciaRepository iTransfereciaRepository;
	
	@Override
	//con REQUIRED ES REDUNDANTE 
	@Transactional(value =TxType.REQUIRED )
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		//actualizar origen
		CuentaBancaria ctaOrigen=this.iCuentaBancariaRepository.buscarPorNumeroCuenta(numeroCtaOrigen);
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.iCuentaBancariaRepository.actualizar(ctaOrigen);
		
		//actualizar destino
		CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.buscarPorNumeroCuenta(numeroCtaDestino);
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.iCuentaBancariaRepository.actualizar(ctaDestino);
		
		//generar la transferencia
		Transferencia t = new Transferencia();
		t.setCuentaBancariaDetino(ctaDestino);
		t.setCuentaBancariaOrigen(ctaOrigen);
		t.setFecha(LocalDateTime.now());
		t.setMonto(monto);
		
		this.iTransfereciaRepository.insertar(t);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	//si le ponemos REQUIRES_NEW al realizar transferencia usamos este
	public void realizarTransferenciaFachada(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		
		this.realizarTransferencia(numeroCtaOrigen, numeroCtaDestino, monto);
	}

}
