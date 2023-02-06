package ssafy.com.lecture.day01;
/*
 * 재귀는 반복하는 프로그래밍 기법
 * */
public class Recursive01 {

	public static void main(String[] args) {
		//1 ~ 5 까지 찍는 반복문 코드를 작성하세요
		int n = 1;
//		while(n<=5) {
//			System.out.println(n);
//			n++;
//		}
		
		
		recursive(n);
		
	}

	private static void recursive(int n) {
		//basis part -> 있어도 없어도 된다.
		if(n==6) {
			return;
		}
		
		
		//inductive part -> 무조건 있어야한다
		System.out.println(n);
		recursive(n+1);
		System.out.println(n);

	}
}
