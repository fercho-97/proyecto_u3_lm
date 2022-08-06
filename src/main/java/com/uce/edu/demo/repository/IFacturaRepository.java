package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaRepository {

	public List<Factura> busacarFacturaInnerJoin(Integer cantidad);

	public List<Factura> busacarFacturaInnerJoin();

	public List<Factura> busacarFacturalOuterJoinRight(Integer cantidad);

	public List<Factura> busacarFacturaOuterJoinLeft(Integer cantidad);

	public List<Factura> busacarFacturalOuterJoinLeft();

}
