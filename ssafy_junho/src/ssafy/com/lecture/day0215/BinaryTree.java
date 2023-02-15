package ssafy.com.lecture.day0215;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
	private Object[] nodes;
	private int lastIndex;
	private final int SIZE;

	public BinaryTree(int size) {
		SIZE = size;
		nodes = new Object[size + 1];// 0인덱스 사용 안함
	}

	public boolean isEmpty() {
		return lastIndex == 0;
	}

	private boolean isFull() {
		return lastIndex == SIZE;
	}

	// 완전이진트리로 추가하는 방법
	public void add(T e) {
		if (isFull()) {
			System.out.println("포화상태입니다..");
			return;
		}
		nodes[++lastIndex] = e;
	}

	public void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(1);
		int current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println(nodes[current]);
			if (current * 2 <= lastIndex)
				queue.offer(current * 2);
			if (current * 2 + 1 <= lastIndex)
				queue.offer(current * 2 + 1);
		}
	}

	public void bfs2() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		int current;
		int level=0;
		while (!queue.isEmpty()) {
			int cnt = queue.size();
			for (int i = 0; i < cnt; i++) {
				current = queue.poll();	
				System.out.print("level : "+level+" : ");
				
				System.out.println(nodes[current]);
				if (current * 2 <= lastIndex)
					queue.offer(current * 2);
				if (current * 2 + 1 <= lastIndex)
					queue.offer(current * 2 + 1);
			}
			level++;
		}
	}

	public static void main(String[] args) {
		BinaryTree<Character> bfs = new BinaryTree(9);

		for (int i = 0; i < 9; i++) {
			bfs.add((char) (65 + i));
		}
		
		
	}

}
