package ssafy.com.lecture.day0213.live;

public class StackTest {

	public static void main(String[] args) {
//		IStack<String> stack = new LinkedListStack<String>();
		LinkedListStack<String> stack = new LinkedListStack<String>();
		
		stack.push("�פ���");
		stack.push("ȫ����");
		stack.push("ī����");
		stack.push("Ÿ����");
		
		System.out.println(stack.size()+"//"+stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.size()+"//"+stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size()+"//"+stack.isEmpty());
	}
}
