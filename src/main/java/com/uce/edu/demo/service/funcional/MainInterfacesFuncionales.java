package com.uce.edu.demo.service.funcional;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodoHO = new ConsumoMetodosHighOrder();

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
			return valorConsultado;}
		);

		LOG.info("HO Supplier 2: " + valorHO1);

		
		metodoHO.consumirConsumer(valor -> System.out.println(valor), 2);
		
		boolean respuesta =metodoHO.consumirPredicate(cadena -> cadena.contains("Z"), "EdisonZ");
		
		LOG.info("Predicate HighOrder: " + respuesta);
		
		
		String valorFinalHO = metodoHO.consumirFunction(valor -> {
			String retorno =valor.toString()+ "A";
			return retorno;
			
		}, 1);
		
		LOG.info("Function HighOrder: " + valorFinalHO);
		
		
	}

}
