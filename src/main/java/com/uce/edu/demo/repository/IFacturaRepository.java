package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaRepository {

	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);

	public List<Factura> buscarFacturaInnerJoin();

	public List<Factura> buscarFacturalOuterJoinRight(Integer cantidad);

	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad);

	public List<Factura> buscarFacturalOuterJoinLeft();

	public List<Factura> busacarFacturaJoinWhere(Integer cantidad);

	public List<Factura> busacarFacturaJoinFetch(Integer cantidad);

}
