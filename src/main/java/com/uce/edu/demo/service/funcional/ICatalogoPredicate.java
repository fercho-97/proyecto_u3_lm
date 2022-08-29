package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface ICatalogoPredicate<T> {

	public Boolean evaluar(T arg1);
}
