package com.ssafy.workshop_generics;

public class GenericMain {

	public static void main(String[] args) {
		
		Generic<Integer> g = new Generic();
		g.setI(1,2,3,4);
		
		String value =g.<String>getValue("2323"); 
		System.out.println(g.getI());
		
	}
}
