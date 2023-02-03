package com.ssafy.workshop_generics;

public class Generic<T>{

	private T i;
	public void setI(T...i) {
		for (T t : i) {
			this.i = t;
		}
		
	}
	public T getI() {
		return i;
	}
	public <E> E getValue(E e) {
		return e;
	}
}
