package ssafy.com.lecture.day0213;

public class ListMain {

	public static void main(String[] args) {
		
		IList list = new MyArrayList();
		list.add(0, "Hello1");
		list.add(1, "Hello2");
		list.add(2, "Hello3");
		list.add(3, "Hello4");
		
		
		list.add(2, "chnage");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
	}
}
