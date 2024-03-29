package ssafy.com.lecture.day0213.sortPr;

import java.util.Arrays;
/*
 * PriroityQueueλ₯? ??΄ κ΅¬ν
 * μ΅λ??
 *            9
 *         8     7
 *       6   5  4  3
 *     2  1
 * μ΅μ? 
 *            1
 *          3   2
 *        5  4 7 6
 *       9 8
 * ?½? : ?? μΆκ??κ³? ?? λ°κΏ
 * ?­?  : ?? ??κ±°λ ?­? ?? κ±°λ ?λ¦¬λ°κΎΈκ³  ?? λ°κΏ
 *           
 *      
 */
public class HeapSort {
	static int heap[] = { 7, 6, 5, 8, 3, 5, 9, 1, 6 };
	public static void main(String[] args) {
		// ?? κ΅¬μ±??€
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
				// ??μ€μ? ? ?°?? μ°ΎκΈ°
				if(c<i-1&&heap[c]<heap[c+1]) {
					c++;
				}
				// λ£¨νΈλ³΄λ€ ???΄ ?¬?€λ©? κ΅ν
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
