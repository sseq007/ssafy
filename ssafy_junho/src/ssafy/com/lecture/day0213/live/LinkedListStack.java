package ssafy.com.lecture.day0213.live;

public class LinkedListStack<E> implements IStack<E> {

	private Node<E> top;
	
	@Override
	public void push(E e) {
		//top���� ����
		top = new Node<E>(e, top);
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			System.out.println("���齺���̾ �Ұ���");
			return null;
		}
		
		Node<E> popNode = top;
		top = popNode.link;
		popNode.link=null;
		return popNode.data;
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			System.out.println("���齺���̾ �Ұ���");
			return null;
		}
		

		return top.data;
	}

	@Override
	public boolean isEmpty() {
		
		return top == null;
	}

	@Override
	public int size() { //top���� ��� ���󰡼� ������ �������� ��
		
		int res =0;
		for(Node<E> temp = top; temp !=null;temp=temp.link) {
			res++;
		}
		return res;
	}

}
