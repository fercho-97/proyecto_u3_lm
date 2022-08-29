package com.uce.edu.demo.service.funcional;
@FunctionalInterface
public interface ICatologoFunction<T,R> {

	public R aplicar (T arg1);
}
