package ssafy.com.lecture.day0214.live;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<T> {

	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;
	public CompleteBinaryTree(int size) {
		
		SIZE = size;
		nodes = new Object[size+1];
	}
	
	private boolean isFull() {
		return lastIndex == SIZE;
	}
	public void add(T e) {
		if(isFull()) return;
		
		nodes[++lastIndex] =e;
	}
	
	public void bfs() {
		//ť���� Ž������� ��ȣ ����
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(0); //��Ʈ������
		
		int current = 0;
		while(!queue.isEmpty()) { //ť�� ����ϰ� �ִ� ������� ��� ó��
			current = queue.poll();
			System.out.println(nodes[current]);
			
			// ���� ����� �ڽĳ����� ť�� �־� ������ ��ٸ��� �ϱ�
			// ���� ���� Ʈ�� : �ڽ��� �ִ� 2
			
			//�����ڽ�
			if(current*2<=lastIndex) queue.offer(current*2);
			
			//������ �ڽ�
			if(current*2<=lastIndex) queue.offer(current*2+1);
			
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	
}