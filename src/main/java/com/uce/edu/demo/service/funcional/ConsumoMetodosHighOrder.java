package com.uce.edu.demo.service.funcional;

import java.math.BigDecimal;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier(IPersonaSupplier<String>  funcion) {
		//String valor = funcion.getNombre();
		//Integer numero = Integer.parseInt(valor);
		
		//return numero;
		
		return funcion.getNombre() + "se proceso el dato";
	}
	
	public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);
		
		
		
	}
	
	public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {
		
		return funcion.evaluar(valor);
	}
	
	
	public String consumirFunction(IPersonaFunction<String, Integer> funcion, Integer valor) {
		return funcion.aplicar(valor);
	}
	
	//--------------------------------------------------------------------------------
	
	public Integer consumirSupplierCatalogo(ICatalogoSupplier<Integer>  funcion) {
		//String valor = funcion.getNombre();
		//Integer numero = Integer.parseInt(valor);
		
		//return numero;
		
		return funcion.getCantidad() + 10;
	}
	
	public void consumirConsumerCatalogo(ICatalogoConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);
		
		
		
	}
	
	public boolean consumirPredicateCatalogo(ICatalogoPredicate<String> funcion, String valor) {
		
		return funcion.evaluar(valor);
	}
	
	
	public BigDecimal consumirFunctionCatalogo(ICatologoFunction<String, BigDecimal> funcion, String cadena) {
		return funcion.aplicar(cadena);
	}
	
}
