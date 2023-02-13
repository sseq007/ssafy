package ssafy.com.lecture.day0213.sortPr;

import java.util.Arrays;

/*
 * ?ˆ«?ë¥? ? ? ˆ?•œ ?œ„ì¹˜ì— ?‚½?…?•˜?Š” ë°©ì‹
 * ?ˆ«??˜ ?œ„ì¹˜ë?? ë¬´ì¡°ê±? ë°”ê¾¸ì§? ?•ˆê³? ?•„?š”?• ?•Œë§? ?œ„ì¹˜ë?? ë°”ê¾¼?‹¤
 * ?•?— ?ˆ?Š” ?ˆ«??Š” ë¯¸ë¦¬ ? •ë¦¬ë˜?–´?ˆ?‹¤ê³? ê°?? •?•œ?‹¤
 * ë²„ë¸” ?„ ?ƒ? •? ¬ë³´ë‹¤ ?š¨?œ¨? ?´?‹¤
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
		// while ?´?š©
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
