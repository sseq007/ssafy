package ssafy.com.lecture.day0213.sortPr;

import java.util.Arrays;
/*
 * PriroityQueueë¥? ?œ„?•´ êµ¬í˜„
 * ìµœë??™
 *            9
 *         8     7
 *       6   5  4  3
 *     2  1
 * ìµœì†Œ?™ 
 *            1
 *          3   2
 *        5  4 7 6
 *       9 8
 * ?‚½?… : ??— ì¶”ê??•˜ê³? ?ˆœ?„œ ë°”ê¿ˆ
 * ?‚­? œ : ??— ?ˆ?Š”ê±°ë‘ ?‚­? œ?•˜?Š” ê±°ë‘ ?ë¦¬ë°”ê¾¸ê³  ?ˆœ?„œ ë°”ê¿ˆ
 *           
 *      
 */
public class HeapSort {
	static int heap[] = { 7, 6, 5, 8, 3, 5, 9, 1, 6 };
	public static void main(String[] args) {
		// ?™?„ êµ¬ì„±?•œ?‹¤
		for (int i = 1; i < heap.length; i++) {
			int c = i;
			do {
				int root = (c-1)/2;
				if(heap[root] < heap[c]) {
					int tmp = heap[root];
					heap[root]=heap[c];
					heap[c]=tmp;
				}
				c=root;
			}while(c != 0);
		}
		//System.out.println(Arrays.toString(heap));
		for (int i = heap.length-1; i >= 0; i--) {
			int tmp=heap[0];
			heap[0]=heap[i];
			heap[i]=tmp;
			int root = 0;
			int c = 1;
			do {
				c = 2*root+1;
				// ??‹ì¤‘ì—?„œ ?” ?°?†ˆ?„ ì°¾ê¸°
				if(c<i-1&&heap[c]<heap[c+1]) {
					c++;
				}
				// ë£¨íŠ¸ë³´ë‹¤ ??‹?´ ?¬?‹¤ë©? êµí™˜
				if(c<i&&heap[root]<heap[c]) {
					tmp=heap[root];
					heap[root]=heap[c];
					heap[c]=tmp;
				}
				root=c;
			}while(c<i);
			
		}
		System.out.println(Arrays.toString(heap));
	}

}
