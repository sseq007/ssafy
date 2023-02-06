package ssafy.com.lecture.day01;
/*
 * 재귀를 이용하여 배열의 요소값을 찍어보세요
 * 
 * */
public class Recursive02 {
	
	static int[] arr = {1,3,5};
	public static void main(String[] args) {
		
		
		recursive(0);
	}
	private static void recursive(int idx) {
		//basis part
		if(idx == arr.length) {
			return;
		}
		// inductive part
		System.out.println(arr[idx]);
		recursive(idx+1);
	}
}
