package ssafy.com.lecture.day01;
/*
 * ��ʹ� �ݺ��ϴ� ���α׷��� ���
 * */
public class Recursive01 {

	public static void main(String[] args) {
		//1 ~ 5 ���� ��� �ݺ��� �ڵ带 �ۼ��ϼ���
		int n = 1;
//		while(n<=5) {
//			System.out.println(n);
//			n++;
//		}
		
		
		recursive(n);
		
	}

	private static void recursive(int n) {
		//basis part -> �־ ��� �ȴ�.
		if(n==6) {
			return;
		}
		
		
		//inductive part -> ������ �־���Ѵ�
		System.out.println(n);
		recursive(n+1);
		System.out.println(n);

	}
}
