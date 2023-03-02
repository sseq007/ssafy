package ssafy.com.lecture.day0302.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class 최단경로 {
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
	static int v,e,k;
	static StringTokenizer st;
	static ArrayList<Node>[] adj;
	static int[] dist;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visit = new boolean[v+1];
		adj = new ArrayList[v+1];
		// 인접리스트 생성
		for (int i = 1; i < v+1; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, c));
		}
		// Dijkstra
		dist[k] = 0;
		PriorityQueue<Node> q = new PriorityQueue();
		q.offer(new Node(k, 0));
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			
			if(!visit[curNode.e]) {
				
				visit[curNode.e]=true;
				
				for (Node nextNode : adj[curNode.e]) {
					if(dist[nextNode.e]>curNode.c+nextNode.c) {
						dist[nextNode.e]=curNode.c+nextNode.c;
						q.offer(new Node(nextNode.e,dist[nextNode.e]));
					}
					
				}
			}
		}
		
		for (int i = 1; i < v+1; i++) {
			System.out.println(dist[i]==Integer.MAX_VALUE?"INF":dist[i]);
		}
		
	}
}
