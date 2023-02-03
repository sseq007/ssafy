package com.ssafy.workshop_generics;

//Generic를 상속하면 type을 지정할 수 있다.
public class SubGeneric extends Generic<String>{

	@Override
	public void setI(String ...i) {
		// TODO Auto-generated method stub
		super.setI(i);
	}
	@Override
	public String getI() {
		// TODO Auto-generated method stub
		return super.getI();
	}
}
