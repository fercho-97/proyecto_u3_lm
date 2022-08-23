package com.uce.edu.demo.service.funcional;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// SUPPLIER
		// clases

		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();

		LOG.info("Supplier Class: " + supplier.getNombre());
		
		// lambda
		IPersonaSupplier<String> supplierLambda = ()-> "Edison2";
		
		LOG.info("Supplier Lambda: " + supplierLambda.getNombre());

		
		
		
		
		// CONSUMER
		// clases
		IPersonaConsumer<String> consumerClass = new PersonaConsumerImpl();
		consumerClass.accept("Prueba Consumer");
		
		

		// lambda

		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		
		consumerLambda.accept("Prueba Consumer Lambda");
		// PREDICATE

		// FUNCTION

		// UNARY OPERATOR (FUNCTION)

	}

}
