package com.uce.edu.demo.service.funcional;

import java.math.BigDecimal;

public class CatalogoFunctionImpl implements ICatologoFunction<String, BigDecimal>{

	@Override
	public BigDecimal aplicar(String arg1) {
		// TODO Auto-generated method stub
		
		BigDecimal desc = BigDecimal.ZERO;
		
		if(arg1.contains("laptop ")) {
			
			desc = new BigDecimal(arg1.length()-15);
			
			System.out.println("se aplica descuento");
			
			
			
		}else{
			
		}
		
		return desc;
	}

}
