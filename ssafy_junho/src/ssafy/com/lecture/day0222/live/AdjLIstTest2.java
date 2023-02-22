package ssafy.com.lecture.day0222.live;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjLIstTest2 {
	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}

	static int[][] adjMatrix;
	
	static Node[] adjList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		adjList = new Node[v]; // head가 모두 null인 상태
		
		int from,to;
		for(int i=0;i<e;i++) {
			from = sc.nextInt();
			to = sc.nextInt();			
			// 무향 그래프
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
			
		}
		print();
		
	}
	static void print() {
		for (Node node : adjList) { // node : 각 정점의 인접리스트의 Head
			System.out.println(node);
		}
	}
}
