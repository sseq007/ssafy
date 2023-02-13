package ssafy.com.lecture.day0210;

import java.util.Comparator;
import java.util.PriorityQueue;

class person{
	String name;
	int age;
	public person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "person [name=" + name + ", age=" + age + "]";
	}
	
	
}


public class MyPriorityQueueTest {

	public static void main(String[] args) {

		PriorityQueue<person> q = new PriorityQueue<person>(
				new Comparator<person>() {
					
					@Override
					public int compare(person o1, person o2) {
						// TODO Auto-generated method stub
						return o2.age-o1.age;
					}
				});

		q.offer(new person("馬", 10));
		q.offer(new person("呪ぉ", 11));
		q.offer(new person("馬け", 12));
		q.offer(new person("馬し", 13));
		q.offer(new person("馬せ", 14));
		
		
		
		while (!q.isEmpty()) {
			System.out.println(q.peek());
			System.out.println(q.poll());
		}

	}
}
