package com.uce.edu.demo.service.funcional;

public class CatalogoPredicateImpl implements ICatalogoPredicate<String>{

	@Override
	public Boolean evaluar(String arg1) {
		// TODO Auto-generated method stub
		
		String cadena= arg1.concat(" CERTIFICADO");
        Boolean val = false;

        if(cadena.length() > 25){
            val = true;
        }
		
		
		return val;
	}

}
