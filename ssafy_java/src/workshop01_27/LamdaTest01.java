package workshop01_27;

interface Printer {
	
	//public static final이 자동으로 생략 변수 선언시 초기화를 꼭 해야한다
	public static String name = "print";
	//public abstract 자동 생략
	public abstract void print(String msg);
	
	//default 붙이면 구현부 가능(인터페이스시 구현부 x)
	public default void getName() {
		System.out.println("Printer 입니다");
	}
	
	
}

interface Printer2{
	void print();
}


public class LamdaTest01 {

	public static void main(String[] args) {
		
		Printer p = new Printer() {

			@Override
			public void print(String msg) {
				// TODO Auto-generated method stub
				System.out.println(msg);
				
			}
		};
		p.getName();
		p.print("미구현 메소드 프린트 입니다");
	
		//lamda expression 1(미구현 메소드 1개)
		
		Printer p1 = (String msg) -> {
			System.out.println(msg);
			System.out.println(msg);
			};
		p1.print("Lamda Expression 1");
		
		//lamda expression 2
		
		Printer p2 = (String msg) -> System.out.println(msg);;
		p2.print("Lamda Expression 2");
		
		//lamda expression 3
		Printer p3 = (msg) -> System.out.println(msg);;
		p3.print("Lamda Expression 3");
		
		//lamda expression 4
		Printer p4 = msg -> System.out.println(msg);;
		p3.print("Lamda Expression 4");
		
		//lamda expression 5
		Printer2 p5 = () -> System.out.println("인자가 없는 프린트");
		p5.print();
		
		
	}
	
}
