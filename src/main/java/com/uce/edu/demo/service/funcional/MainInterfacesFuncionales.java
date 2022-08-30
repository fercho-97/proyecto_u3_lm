package com.uce.edu.demo.service.funcional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.print.attribute.HashDocAttributeSet;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static boolean prueba(Integer numero){
		
		boolean valida= numero>=3;
		return valida;
	}
	
	
public static void imprimir(String cadena){
		
		System.out.println(cadena);
	}

public static void guardar(String elementoAInsertar){
	
	
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		

		// SUPPLIER
		// clases

		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();

		LOG.info("Supplier Class: " + supplier.getNombre());

		// lambda
		IPersonaSupplier<String> supplierLambda = () -> "Edison2";

		LOG.info("Supplier Lambda: " + supplierLambda.getNombre());

		// CONSUMER
		// clases
		IPersonaConsumer<String> consumerClass = new PersonaConsumerImpl();
		consumerClass.accept("Prueba Consumer");

		// lambda

		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);

		consumerLambda.accept("Prueba Consumer Lambda");
		// PREDICATE
		// clases

		// lambda
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("z");
		LOG.info("Predicate Lambda: " + predicateLambda.evaluar("jajja"));

		// FUNCTION

		// lambda
		IPersonaFunction<Integer, String> lambdaFunction = cadena -> cadena.length();
		LOG.info("Predicate Lambda: " + lambdaFunction.aplicar("Alexander"));

		IPersonaFunction<Integer, String> lambdaFunctionClase = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		LOG.info("Predicate Lambda: " + lambdaFunctionClase.aplicar("7"));

		// UNARY OPERATOR (FUNCTION)
		// lambda

		IPersonaUnaryOperator<String> unaryLambda = cade -> {
			String valorFinal = cade.concat(" sufijo");
			return valorFinal;
		};

		LOG.info("UnaryOperator Lambda: " + unaryLambda.apply("Francisco"));

		// Metodos HIgh Order

		String valorHO = metodoHO.consumirSupplier(() -> "Hola Mundo");

		LOG.info("HO Supplier: " + valorHO);

		String valorHO1 = metodoHO.consumirSupplier(() -> {
			String valorConsultado = "174856";
			return valorConsultado;
		});

		LOG.info("HO Supplier 2: " + valorHO1);

		metodoHO.consumirConsumer(valor -> System.out.println(valor), 2);

		boolean respuesta = metodoHO.consumirPredicate(cadena -> cadena.contains("Z"), "EdisonZ");

		LOG.info("Predicate HighOrder: " + respuesta);

		String valorFinalHO = metodoHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "A";
			return retorno;

		}, 1);

		LOG.info("Function HighOrder: " + valorFinalHO);

		*/
		//------------------------------------------------------------------------------
		//Java
		LOG.info("JAVA Supplier");
		Stream<String> test = Stream.generate(()->"Edison 3").limit(7);
		test.forEach(cadena -> System.out.println(cadena));
		
		
		LOG.info("JAVA Consumer");
		List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5);
		listaNumeros.forEach(numero-> System.out.println(numero));
		
		
		
		LOG.info("JAVA Predicate");
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero -> prueba(numero));
		
		nuevaLista.forEach(numero-> System.out.println(numero));
		
		
		LOG.info("JAVA Function");
		Stream<String> listaCambiada =  listaNumeros.stream().map(numeroLista ->{
			Integer valor = numeroLista +1;
			String cadena = "num: " + valor.toString();
			return cadena;
		} );
		
		//Declarativa: ideas intencion
		listaCambiada.forEach(cadena -> imprimir(cadena));
		
		
		//Imperativa: paso a paso
		//for ( String in : listaCambiada) {
	//	
	//	
	//	}
		
		
		List<String> lista = new ArrayList<String>();
		//Map<String, String> mpa1 = new HashDocAttributeSet(null)
		
	
		
		
		//------------------------------------------------------------------------------
		
		ConsumoMetodosHighOrder metodoHO = new ConsumoMetodosHighOrder();
		
		// IMPLEMENTACION INTERFACES
		// Supplier
		ICatalogoSupplier<Integer> catalogoSupplierLambda = () -> {
			Integer suma = 2 + 10;
			return suma;
		};

		LOG.info("Catalogo Supplier Lambda: " + catalogoSupplierLambda.getCantidad());
		
		
		ICatalogoSupplier<Integer> catalogoSupplier = new CatalogoSupplierImpl();
		
		LOG.info("Catalogo Supplier: " + catalogoSupplier.getCantidad());
		
		
		// Metodos HIgh Order

		Integer valorHO = metodoHO.consumirSupplierCatalogo(() -> 10);

		LOG.info("HO Supplier: " + valorHO);
		
		

		// Consumer
		ICatalogoConsumer<String> catalogoConsumerLambda = cadena -> LOG.info("Registro de producto ConsummerLambda: " + cadena);

		catalogoConsumerLambda.accept("Sauvage");
		
		
		ICatalogoConsumer<Integer> catalogoConsumer = new CatalogoConsumerImpl();
		catalogoConsumer.accept(10);
		
		// Metodos HIgh Order
		
		metodoHO.consumirConsumerCatalogo(valor -> System.out.println(valor), 4);
		

		// Predicate

		ICatalogoPredicate<Integer> catalogoPredicateLambda = valor -> {
			boolean confimacion = false;

			if (valor % 2 == 0) {

				confimacion = true;
			} else {

			}

			return confimacion;
		};
		
		LOG.info("Catalogo Predicate Lambda: " + catalogoPredicateLambda.evaluar(8));
		
		ICatalogoPredicate<String> catalogoPredicate = new CatalogoPredicateImpl();
		
		LOG.info("Catalogo Predicate : " + catalogoPredicate.evaluar("Manuel Garcia"));
		
		// Metodos HIgh Order
		
		boolean val = metodoHO.consumirPredicateCatalogo(cad -> cad.equals("lenovo Yoga Pro"), "Asus");
		
		LOG.info("Predicate HighOrder: " + val);

		// Function
		ICatologoFunction<String, Integer> catalogoFunctionLambda = cadena -> cadena.concat("001").length();
		LOG.info("Cantidad de digitas en el ruc: "+catalogoFunctionLambda.aplicar("1716487952"));

		ICatologoFunction<String, BigDecimal> catalogoFunction = new CatalogoFunctionImpl();
		LOG.info("Catalogo Function: "+catalogoFunction.aplicar("Asus evo 500"));
		
		// Metodos High Order
		
		
		BigDecimal ho = metodoHO.consumirFunctionCatalogo(cadena ->{ 
			BigDecimal des = BigDecimal.ZERO;
			des = new BigDecimal(cadena.length());
			return des;
		}
		, "abx2" );
		
		LOG.info("Catalogo Function HighOrder : "+ ho);
		
		// Unary Operator
		ICatalogoUnaryOperator<Integer> catalogoUnaryLambda = valor -> {
			Double perdida = valor * 0.075;
			Double valorFinal = perdida + valor ;
			Integer valorFijo = (int) Math.round(valorFinal);
			return  valorFijo;
		};
		
		LOG.info("UnaryOperator Lambda: " + catalogoUnaryLambda.apply(500));
		
		
		ICatalogoUnaryOperator<String> catalogoUnary = new CatalogoUnaryOperatorImpl();
		LOG.info("UnaryOperator: "+ catalogoUnary.apply("Nimbus 2001"));
		
		
				
	}

}
