package com.ssafy.c_inheritance;

class Parents{
	String name;
	int age;
	public Parents() {
		System.out.println("Parents");
	}
	
	public String toString() // 생략되어있다
	{	
		return "";
	}
	//에러 나는 이유 overload 에러
	public int toString() {
		return 0;
	}
}
class Childs extends Parents{
	String play;
	public Childs(){
		System.out.println("Childs");
	}
}



public class InheritanceTest01 {

	
	public static void main( String[] args) {
		
		Parents p = new Parents();
		Childs c = new Childs();
	}
}
