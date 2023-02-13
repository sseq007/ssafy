package ssafy.com.lecture.day0213.sortPr;

import java.util.Arrays;

// ?‘ê°œë?? ë¹„êµ?•´ ê°?ë©´ì„œ ?” ?‘?? ?†ˆ?? ?•?œ¼ë¡?  o(n^2)
// ê²°ê³¼? ?œ¼ë¡? ê°??¥?°?†ˆ?´ ë§¨ë’¤ë¡? ê°?ê¸? ?•Œë¬¸ì— ë²”ìœ„ë¥? ?’¤?–´?„œ ë¶??„° ì¤„ì—¬?‚˜ê°??Š” ë°©ì‹
// ex
/*
 * 1, 10, 7, 6, 3, 4, 5, 2, 8, 9
 * 1, 10, 7, 6, 3, 4, 5, 2, 8, 9
 * 1, 7, 10, 6, 3, 4, 5, 2, 8, 9
 * 1, 7, 6, 10, 3, 4, 5, 2, 8, 9
 * 1, 7, 6, 3, 10, 4, 5, 2, 8, 9
 * ...
 * 1, 7, 6, 3, 4, 5, 2, 8, 9, 10
 * ?‹¤?‹œ N-1 ê¹Œì? ?ë¦¬êµ?™˜ ë°˜ë³µ
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
