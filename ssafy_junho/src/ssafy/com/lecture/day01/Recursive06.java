package ssafy.com.lecture.day01;

import java.util.Arrays;

/*
 * 배열요소값중 2개를 뽑아 출력하세요.(조합)
 * 
 * */
public class Recursive06 {
	
	//원본 배열
	static int[] arr = {1,3,5};
	//저장배열
	static int[] sel = new int[2];
	public static void main(String[] args) {
			

		recursive(0,0);
		
	}
	/*
	 * idx : 원본배열의 인덱스
	 * k : 저장배열의 인덱스
	 * */
	
	private static void recursive(int idx, int k) {
		//basis part
		
		//2개를 다 뽑았으면 그만
 		if(k==sel.length) {
 			System.out.println(Arrays.toString(sel));
			return;
		}
 		//더이상 고를값이 없는 경우
 		if(idx==arr.length) return;
		
		//inductive part
		//저장하는 경우
		sel[k]=arr[idx];
		recursive(idx+1, k+1);
		
		//저장하지 않는 경우
		recursive(idx+1, k);
	}
	
}
