package ssafy.com.lecture.day0228;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 인접행렬이나 인접리스트를 이용하여 그래프를 구성하고
 * 간선이 있고 방문하지 않은 정점중 비용이 가장 작은 정점을 V-1 만큼 반복하면서
 * 선태갷 나가는 알고리즘
 * V-1까지 순환이 되지 않는 간선을 선택한다.
 * */
public class 프림_인접리스트 {
	static class Vertex{
		int e,c;

		public Vertex(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}
		
	}
	static int V, E;
	static ArrayList<Vertex>[] adj;
	static int[] dist;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("크루스칼.txt"));
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
		Arrays.fill(dist, Integer.MAX_VALUE);
		//방문 배열
		v = new boolean[V];
		
		//임의의 정점(관습적으로 0번을 선택)
		dist[0]=0;
		
		//선택된 정점과 인접한 정점들의 값을 찾아서 정점배열에 업데이트한다
		//위 작업을 V-1번 반복한다.
		
		for (int cnt = 0; cnt < V-1; cnt++) {
			// 방문하지 않은 정점중 최소비용정점을 찾는다
			int minIdx = -1;
			int minDist = Integer.MAX_VALUE;
			for (int i = 0; i < V; i++) {
				if(!v[i]&&minDist>dist[i]) {
					minIdx = i;
					minDist = dist[i];
				}
			}
			// 최소비용 정점 minIdx
			v[minIdx]=true;
			
			//방문되지 않은 정점중 
			//minIdx 정점과 연결되어 있는 정점들을 찾아 업데이트 한다
			//minIdx : 출발정점
			//i=>adj[minIdx].get(i).e : 도착정점
			for (int i = 0; i < adj[minIdx].size(); i++) {
				//리스트에는 연결되니 않은 정점은 add가 되지 않으므로 연결확인 코도는 필요치 않다.
				if(!v[adj[minIdx].get(i).e]&&adj[minIdx].get(i).c<dist[adj[minIdx].get(i).e]) {
					dist[adj[minIdx].get(i).e]=adj[minIdx].get(i).c;
				}
			}
			
			int sum=0;
			for (int i = 0; i < dist.length; i++) {
				sum+=dist[i];
			}
			System.out.println(sum);
			
		}
		
	}

}
