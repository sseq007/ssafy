package ssafy.com.lecture.day01;

import java.util.Arrays;

/*
 * 0 ~ 2 까지의 값 3개 고르는 프로그램을 구하세요
 * 단 중복해서 고를수 있다.
 * 
 * 순열
 * */
public class Recursive10 {

	
	public static void main(String[] args) {
		int[] arr = {1,3,5};
		
		recursive(arr,new int[3],0,new boolean[arr.length]);
	}

	/*
	 * arr[] : 원본 배열
	 * sel[] : 담는 배열
	 * k : 담는배열 인덱스
	 * v[] : 사용여부
	 * */
	private static void recursive(int[]arr,int[] sel, int k,boolean[] v ) {
		//basis part
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			
			return;
		}
		
		//inductive part
		for(int i=0;i<arr.length;i++) {
			if(!v[i]) {
				v[i]=true;
				sel[k]=arr[i];
				recursive(arr,sel, k+1,v);
				v[i]=false;
			}
		}
		
		
		
	}
}


