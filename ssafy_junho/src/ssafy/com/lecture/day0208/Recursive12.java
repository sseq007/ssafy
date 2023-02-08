package ssafy.com.lecture.day0208;

import java.util.Arrays;

/*
 * 배열의 값 3개중 2개 고르는 프로그램을 구하세요
 * 
 * 중복조합
 * */
public class Recursive12 {

	static int cnt=0;
	public static void main(String[] args) {
		int[] arr = {1,3,5};
		
		recursive(arr,new int[2],0,0);
		System.out.println("경우의 수 :"+cnt);
	}
	/*
	 * arr[] : 원본 배열
	 * sel[] : 담는 배열
	 * s : 원본배열 인덱스
	 * d : 담는배열 인덱스
	 * 
	 * */
	private static void recursive(int[] arr, int[] sel, int s, int d) {
		//basis part
		if(d == sel.length) {
			System.out.println(Arrays.toString(sel));
			cnt+=1;
			return;
		}
		
		//inductive part
		
		for(int i=s;i<arr.length;i++) {
			sel[d]=arr[i];
			recursive(arr, sel, i, d+1);
		}
		
		
	}

	
}
