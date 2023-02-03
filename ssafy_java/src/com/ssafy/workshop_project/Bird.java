package com.ssafy.workshop_project;

public class Bird extends Animal implements IFly{

	
	public void fly() {
		System.out.println("새가 난다");
	}
	@Override
	public void breath() {
		System.out.println("새가 숨을 쉰다");
	}

}
