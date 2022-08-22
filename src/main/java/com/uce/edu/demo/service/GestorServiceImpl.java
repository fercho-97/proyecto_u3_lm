package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IDetalleRepository;
import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.IFacturaSupermaxiRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.FacturaElectronicaSupermaxi;
import com.uce.edu.demo.repository.modelo.FacturaSupermaxi;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class GestorServiceImpl implements IGestorService {

	private static Logger LOG = Logger.getLogger(GestorServiceImpl.class);

	@Autowired
	private IFacturaSupermaxiRepository iFacturaSupermaxiRepository;

	@Autowired
	private IProductoRepository iProductoRepository;

	@Autowired
	private IClienteRepository iClienteRepository;

	@Autowired
	private IDetalleRepository iDetalleRepository;

	@Autowired
	private IFacturaElectronicaRepository iFacturaElectronicaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	
	public void crearFacturaDetalles(String cedulaCliente, String numeroFactura, List<String> codigos) {
		// TODO Auto-generated method stub
		
		
		

		Cliente c = this.iClienteRepository.buscarPorCedula(cedulaCliente);
		FacturaSupermaxi f = new FacturaSupermaxi();
		f.setCliente(c);
		f.setFecha(LocalDateTime.now());
		f.setNumero(numeroFactura);
		

		this.iFacturaSupermaxiRepository.insertar(f);

		Integer items = 0;
		BigDecimal monto = new BigDecimal(0);
		
		LOG.info("Cantidad de producots"+codigos.size());

		for (String cod : codigos) {

			Detalle d = new Detalle();
			d.setCantidad(1);
			d.setFactura(f);

			Producto p = this.iProductoRepository.buscarCodigoBarras(cod);
			d.setProducto(p);
			BigDecimal subtotal = p.getPrecio().multiply(new BigDecimal(d.getCantidad()));
			d.setSubtotal(subtotal);
			this.iDetalleRepository.insertar(d);

			items++;
			monto = monto.add(subtotal);

			actualizarStock(cod);

		}

		f.setMonto(monto);
		this.iFacturaSupermaxiRepository.actualizar(f);
		crearFacturaElectronica(numeroFactura, monto, items);

	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizarStock(String codigoBarras) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actulizarStock(codigoBarras);

		Producto p = this.iProductoRepository.buscarCodigoBarras(codigoBarras);

		if (p.getCantidad().equals(0)) {

			throw new RuntimeException();

		} else {

		}

	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void crearFacturaElectronica(String numeroFactura, BigDecimal monto, Integer items) {
		// TODO Auto-generated method stub

		FacturaElectronicaSupermaxi fe = new FacturaElectronicaSupermaxi();
		fe.setFecha(LocalDateTime.now());
		fe.setMonto(monto);
		fe.setNumero(numeroFactura);
		fe.setNumeroItems(items);

		this.iFacturaElectronicaRepository.insertar(fe);
	}

}
