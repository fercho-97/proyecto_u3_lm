package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface ICatalogoConsumer<T> {

	public void accept(T arg1);
}
