package ssafy.com.lecture.day0220;

public class DeBugTest {

	public static void main(String[] args) {
		
		int a= 10;
		int b= 20;
		
 		method(a,b);
	}

	private static void method(int c, int d) {

		int e= 0;
		String msg = "Hello";
		for(int i=0;i<100;i++) {
			msg+="111";
			e+=(c+1);
		}
	}
}
	
