package ssafy.com.lecture.day0209;

import java.util.Arrays;

/*
 * 배열의 부분집합 구하기 --> 부분집합 = 조합의 모든 집합
 * 
 * 
 * */
public class Recursive13 {

	static int cnt=0;
	public static void main(String[] args) {
		int[] arr = {1,3,5};
		
		recursive(arr,new boolean[arr.length],0,0);
		System.out.println("경우의 수 :"+cnt);
	}
	
	/*
	 * arr[] : 원본 배열 sel[] : 담는 배열 s : 원본배열 인덱스
	 * 
	 */
	private static void recursive(int[] arr, boolean[] sel, int idx, int k) {
		// basis part
		if (idx == arr.length) {
//			System.out.println(Arrays.toString(sel));

			for (int i = 0; i < sel.length; i++) {
				if (k == 2) {
					if (sel[i]) {
						System.out.print("true :" + arr[i] + " ");
					}
//				else {
//					System.out.print("false :"+arr[i]+" ");					
//				}
				}
			}
			System.out.println();
			return;
		}

		//inductive part
		
		
		sel[idx]= true;
		recursive(arr, sel, idx+1,k+1);
		sel[idx]=false;
		recursive(arr, sel, idx+1,k);
		
	}

	
}
