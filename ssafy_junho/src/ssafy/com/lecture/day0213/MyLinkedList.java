package ssafy.com.lecture.day0213;

public class MyLinkedList implements IList {

	class Node{
		Node next;
		Object obj;
		public Node(Node next, Object obj) {
			super();
			this.next = next;
			this.obj = obj;
		}
		public Node(Object obj) {
			this.obj = obj;
		}
		@Override
		public String toString() {
			return "Node [next=" + next + ", obj=" + obj + "]";
		}
		
	}
	//ù���� ��� head�� ����
	private Node head;
	
	//������ ��� head�� ����
	private Node tail;
	
	//����� ���尹��
	private int size;
	
	
	public void addToFirst(Object obj) {
		Node newnode = new Node(obj);
		newnode.next = head;
		head = newnode;
		size++;
		if(head.next==null) {
			head.next=tail;
		}
	}
	public Node getNode(int index) {
		if(size>index) {
			Node x = head;
			for(int i=0;i<index;i++) {
				x=x.next;
			}
			return x;
		}
		return null;
	}
	@Override
	public void add(int index, Object obj) {
		if(index==0) {
			addToFirst(obj);
		}else{
			Node temp1 = getNode(index-1);
			Node temp2 = temp1.next;
			Node newNode = new Node(obj);
			temp1.next = newNode;
			newNode.next = temp2;
		}
	}

	@Override
	public Object get(int index) {
		Node node = getNode(index);
		if(node==null) return null;
		return node.obj;
	}

	@Override
	public Object remove(int index) {
		//������ ����� ���ǰ�
		Node prev = getNode(index-1);
		//������ ���
		Node delnode = getNode(index);
		
		prev.next = delnode.next;
		size--;
		return delnode.obj;
	}
//������ �ʹٴٴٴٴٴٴٴٴٴ�
}

