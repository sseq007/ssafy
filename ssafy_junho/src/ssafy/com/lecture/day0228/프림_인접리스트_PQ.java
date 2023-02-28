package ssafy.com.lecture.day0228;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * PriorityQueue를 이용하여 minIdx를 구함으로써
 * 최소값을 구하는 복잡도를 Q(logN)으로 바꿈으로써 향상된 프림을 구현 할 수 있다.
 * */
public class 프림_인접리스트_PQ {
	static class Vertex implements Comparable<Vertex>{
		int e,c;

		public Vertex(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}
		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.c, o.c);
		}
		
	}
	static int V, E;
	static ArrayList<Vertex>[] adj;
	static int[] dist;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("크루스칼.txt"));
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		adj = new ArrayList[V];
		
		for (int i = 0; i < adj.length; i++) {
			adj[i]= new ArrayList();
		}
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adj[a].add(new Vertex(b, c));
			adj[b].add(new Vertex(a, c));
		}
		
		//정점 배열
		dist = new int[V];
		// 정점배열의 값을 무한대로 설정
		//방문 배열
		v = new boolean[V];
		//dist 모든 값을 무한대로 한다
		Arrays.fill(dist, Integer.MAX_VALUE);
		//임의의 정점(관습적으로 0번을 선택)
		dist[0]=0;
		//비용이 최소값인 정점을 찾기위해 PriorityQueue를 생성한다
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
		//시작정점을 Q에 넣는다
		Q.add(new Vertex(0, 0));
		//거리 누적 변수
		int sum=0;
		//Q가 빌때까지 하나씩 빼면서 최소정점을 찾아 정점배열에 업데이트 한다.
		while(!Q.isEmpty()) {
			//거리가 가장 작은 정점을 poll 한다.
			Vertex p = Q.poll();
			//방문하지 않은 정점이라면
			if(!v[p.e]) {
				v[p.e]=true;
				sum+=p.c;
				for (Vertex next : adj[p.e]) {
					if(!v[next.e]&&next.c<dist[next.e]) {
						dist[next.e]=next.c;
						Q.add(next);
						
					}
				}
			}
		}
			System.out.println(sum);
			
		}
		
	}


