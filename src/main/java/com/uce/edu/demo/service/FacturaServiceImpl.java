package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepository iFacturaRepository;
	
	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.busacarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.busacarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturalOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.busacarFacturalOuterJoinRight(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.busacarFacturaOuterJoinLeft(cantidad);
	}

	@Override
	public List<Factura> buscarFacturalOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.busacarFacturalOuterJoinLeft();
	}

}
