package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IFacturaSupermaxiRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.FacturaSupermaxi;
import com.uce.edu.demo.repository.modelo.Producto;


@Service
public class FacturaSupermaxiServiceImpl implements IFacturaSupermaxiService{

	@Autowired
	private IFacturaSupermaxiRepository iFacturaSupermaxiRepository;
	
	@Autowired
	private IClienteRepository iClienteRepository;
	
	@Autowired IProductoRepository iProductoRepository;
	
	@Override
	public void insertar(FacturaSupermaxi factura) {
		// TODO Auto-generated method stub
		
		this.iFacturaSupermaxiRepository.insertar(factura);
		
	}

	@Override
	public void actulizar(FacturaSupermaxi factura) {
		// TODO Auto-generated method stub
		
		this.iFacturaSupermaxiRepository.actualizar(factura);
	}

	@Override
	public FacturaSupermaxi buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaSupermaxiRepository.buscarPorNumero(numero);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal procesarFactura(String cedulaCliente, String numeroFactura, List<String> codigoBarras) {
		// TODO Auto-generated method stub
		List<Detalle> listDetalleFacturas = new ArrayList<Detalle>();
		FacturaSupermaxi factura = new FacturaSupermaxi();
		Cliente cliente = this.iClienteRepository.buscarPorCedula(cedulaCliente);
		factura.setCliente(cliente);
		factura.setNumero(numeroFactura);
		factura.setFecha(LocalDateTime.now());

		BigDecimal monto= BigDecimal.ZERO;
		for (String codigo : codigoBarras) {
			Producto producto = this.iProductoRepository.buscarCodigoBarras(codigo);
			Detalle detalleFactura = new Detalle();
			detalleFactura.setCantidad(1);
			detalleFactura.setProducto(producto);
			detalleFactura.setFactura(factura);
			detalleFactura.setSubtotal(producto.getPrecio());
			monto = monto.add(detalleFactura.getSubtotal());
			listDetalleFacturas.add(detalleFactura);
			
			
			this.iProductoRepository.actulizarStock(codigo);

		}
		
		

		factura.setDetalles(listDetalleFacturas);
		factura.setMonto(monto);

		this.iFacturaSupermaxiRepository.insertar(factura);	
		
		return monto;
	}

	

	
}
