package ssafy.com.lecture.day01;
/*
 * 재귀를 이용하여 배열의 요소값의 합과 곱을 구하세요
 * 단 함수의 인자는 (idx,val)으로만 구현하세요
 * */
public class Recursive07 {
	static int[] arr = {1,3,5};
	public static void main(String[] args) {
		
		
		recursive(0,1);
		
		
	}
	private static void recursive(int idx,int val) {
		//basis part
		if(idx == arr.length) {
			System.out.println(val);
			return;
		}
		//logic part
		// inductive part
//		int tmp = val;
		
		
		recursive(idx+1, val+arr[idx]);
	
		recursive(idx+1, val*arr[idx]);
		
		
	
	}
}
