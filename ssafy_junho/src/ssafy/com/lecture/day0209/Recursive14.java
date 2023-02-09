package ssafy.com.lecture.day0209;

import java.util.Arrays;

/*
 * 배열의 값 3개중 2개 고르는 프로그램을 구하세요
 * 
 * 비트 순열
 * */
public class Recursive14 {

	static int cnt=0;
	public static void main(String[] args) {
		int[] arr = {1,3,5};
		
		recursive(arr,new int[3],0,0);
		System.out.println("경우의 수 :"+cnt);
	}
	/*
	 * arr[] : 원본 배열
	 * sel[] : 담는 배열
	 * d : 담는배열 인덱스
	 * bit: 사용여부 배열
	 * 
	 * */
	
	private static void recursive(int[] arr, int[] sel, int k, int bit) {
		//basis part
		if(k == sel.length) {
			System.out.println(Arrays.toString(sel));
			cnt+=1;
			return;
		}
		
		//inductive part
		
		for(int i=0;i<arr.length;i++) {
			
			if((bit&1<<i)==0) {
				
				sel[k]=arr[i];
				recursive(arr, sel, k+1, bit|1<<i);
			}
		}
		
		
	}

	
}
