package ssafy.com.lecture.day0213.sortPr;

import java.util.Arrays;

// ?��개�?? 비교?�� �?면서 ?�� ?��?? ?��?? ?��?���?  o(n^2)
// 결과?��?���? �??��?��?��?�� 맨뒤�? �?�? ?��문에 범위�? ?��?��?�� �??�� 줄여?���??�� 방식
// ex
/*
 * 1, 10, 7, 6, 3, 4, 5, 2, 8, 9
 * 1, 10, 7, 6, 3, 4, 5, 2, 8, 9
 * 1, 7, 10, 6, 3, 4, 5, 2, 8, 9
 * 1, 7, 6, 10, 3, 4, 5, 2, 8, 9
 * 1, 7, 6, 3, 10, 4, 5, 2, 8, 9
 * ...
 * 1, 7, 6, 3, 4, 5, 2, 8, 9, 10
 * ?��?�� N-1 까�? ?��리교?�� 반복
 */
public class BubleSort {
	static int arr[] = { 1, 10, 7, 6, 3, 4, 5, 2, 8, 9 };
	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
