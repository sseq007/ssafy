package workshop01_27;

interface Calc{
	int calc(int a,int b);
	
}

public class LamdaTest02 {

	public static void main(String[] args) {
		
		Calc c;
		c=(a,b)->{return a+b;};
		System.out.println(c.calc(5, 6));
		
		c=(a,b)->{return a*b;};
		System.out.println(c.calc(5, 6));     
		
	}
}


