package com.ssafy.workshop_project;


//Ainmal를 상속받을 경우 superman이 human이 되지 않는다 
public class Superman extends Human implements IFly{

	@Override
	public void fly() {
		System.out.println("슈퍼맨이 날아다녀요");
		
	}

	
	
	
	

}
