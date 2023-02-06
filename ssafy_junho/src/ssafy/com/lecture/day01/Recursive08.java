package ssafy.com.lecture.day01;
/*
 * 재귀를 이용하여 인자값과 배열값을 변화
 * */
public class Recursive08 {
	static int[] arr = new int[1];
	static int si=0;
	public static void main(String[] args) {
		
		
		recursive(1);
	}
	private static void recursive(int i) {
		//basic part
		
		if(i==5) return;
		
		//inductive part
		
//		arr[0]++;
		si++;
//		System.out.println("before arr = "+arr[0]);
		System.out.println("before si = "+si);
		recursive(i+1);
//		System.out.println("after i = "+i);
//		arr[0]--;
		si--;
//		System.out.println("after arr = "+arr[0]);
		System.out.println("after si = "+si);
		
	}
	
		
	
	
}
