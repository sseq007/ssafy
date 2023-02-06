package ssafy.com.lecture.day01;
/*
 * 재귀를 이용하여 배열의 요소값의 합과 곱을 구하세요
 * 
 * */
public class Recursive05 {
	static int sum=0;
	static int mul=1;
	static int[] arr = {1,3,5};
	public static void main(String[] args) {
		
		recursive(0);
		
		
	}
	private static void recursive(int idx) {
		//basis part
		if(idx == arr.length) {
			System.out.println(sum);
			System.out.println(mul);
			return;
		}
		//logic part
		// inductive part
		sum+=arr[idx];
		mul*=arr[idx];
		recursive(idx+1);
	}
}
