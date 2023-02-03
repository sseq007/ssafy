package com.ssafy.workshop_project;

public class DispathcerMain {

	public static void toBreath(Animal a) {
		a.breath();
	}
	public static void toFly(IFly f) {
		f.fly();
	}
	public static void main(String[] args) {
		
		//Aniaml a = new Animal(); 불가
		Dog d = new Dog();
		Cat c = new Cat();
		Bird b = new Bird();
		Human h = new Human();
		Superman s = new Superman();
		
		toFly(b);
		toFly(s);
		
		
		
		
		toBreath(b);
		toBreath(d);
		toBreath(c);
		/*상위클래스의 1번째 용도*/
//		Animal[] ani = new Animal[3];
//		ani[0]=d;
//		ani[1]=c;
//		ani[2]=b;
//		
//		System.out.println("----------------------------------------------");
//		for(Animal animal : ani) {
//			animal.breath();
//		}
	}
}
