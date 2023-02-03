package com.homework0203;

public class NameNotFoundException extends Exception {

	private String name;
	
	public NameNotFoundException(String name) {
		
		System.out.println(name+" 이름을 포함하는 사용자가 존재하지 않습니다");
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
}
