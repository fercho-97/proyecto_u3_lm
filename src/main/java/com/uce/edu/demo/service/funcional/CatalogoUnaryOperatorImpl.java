package com.uce.edu.demo.service.funcional;

import java.time.LocalDateTime;

public class CatalogoUnaryOperatorImpl implements ICatalogoUnaryOperator<String>{

	@Override
	public String apply(String arg1) {
		// TODO Auto-generated method stub
		LocalDateTime fechaInstante = LocalDateTime.now(); 
		String cadena = arg1.concat(" Fecha de pedido: " + fechaInstante);
		
		
		return cadena;
	}

}
