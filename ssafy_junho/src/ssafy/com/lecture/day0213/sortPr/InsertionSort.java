package ssafy.com.lecture.day0213.sortPr;

import java.util.Arrays;

/*
 * ?��?���? ?��?��?�� ?��치에 ?��?��?��?�� 방식
 * ?��?��?�� ?��치�?? 무조�? 바꾸�? ?���? ?��?��?��?���? ?��치�?? 바꾼?��
 * ?��?�� ?��?�� ?��?��?�� 미리 ?��리되?��?��?���? �??��?��?��
 * 버블 ?��?��?��?��보다 ?��?��?��?��?��
 */
public class InsertionSort {
	static int arr[] = { 1, 10, 7, 6, 3, 4, 5, 2, 8, 9 };
	public static void main(String[] args) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i; j>=0&&arr[j]>arr[j+1] ; j--) {
				int tmp = arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=tmp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		// while ?��?��
//		for (int i = 0; i < arr.length-1; i++) {
//			int j = i;
//			while (j>=0&&arr[j]>arr[j+1] ) {
//				int tmp = arr[j];
//				arr[j]=arr[j+1];
//				arr[j+1]=tmp;
//				j--;
//			}
//		}
//		System.out.println(Arrays.toString(arr));
	}

}
