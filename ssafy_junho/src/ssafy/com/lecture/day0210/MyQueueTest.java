package ssafy.com.lecture.day0210;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueueTest {

	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(1);
		q.offer(2);
		q.offer(5);
		q.offer(4);
		q.offer(3);
		

		while(!q.isEmpty()) {
			
			System.out.println(q.poll());
		}
		
		
	}
}
