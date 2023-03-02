package ssafy.com.lecture.day0302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

import ssafy.com.lecture.day0302.Dijkstra_인접리스트.Node;

public class Dijkstra_인접리스트 {
	static class Node implements Comparable<Node>{
		int e,c;
		public Node(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.c, o.c);
		}
	}
	static int V,E;
	static ArrayList<Node>[] adj;
	static int[] dist;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		v = new boolean[V];
		adj = new ArrayList[V];
		// 인접리스트 생성
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adj[a].add(new Node(b, c));
		}
		// Dijkstra
		dist[0] = 0;
		PriorityQueue<Node> q = new PriorityQueue();
		q.offer(new Node(0, 0));
		System.out.println(1);
		while (!q.isEmpty()) {
			Node node = q.poll();
			v[node.e]=true;
//				if(dist[node.e]<node.c) continue;
			for (Node next : adj[node.e]) {
				// next 도착정점
				if (!v[next.c]&&dist[next.e] > node.c + next.c) {
					dist[next.e] = node.c + next.c;
					q.offer(next);
				}
			}
			
		}
		// minIdx : 시작정점
		// minIdx == -1 연결되지 않을수 있다.
		System.out.println(Arrays.toString(dist));

	

	}
}
