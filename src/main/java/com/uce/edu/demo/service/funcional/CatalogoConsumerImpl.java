package com.uce.edu.demo.service.funcional;

public class CatalogoConsumerImpl implements ICatalogoConsumer<Integer>{

	@Override
	public void accept(Integer arg1) {
		// TODO Auto-generated method stub
		System.out.println("Numero de visitas: " + arg1);
	}

}
