package ssafy.com.lecture.day0228;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 * 간선리스트를 이용하여 그래프를 구성하고
 * 코스트를 기준으로 정렬한 후에
 * V-1까지 순환이 되지 않는 간선을 선택한다.
 * */
public class 크루스칼01 {
	static int V,E;
	static int[] parents;
	static class Edge implements Comparable<Edge>{
		int s,e,c;
		public Edge(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
			
		}
		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", c=" + c + "]";
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.c, o.c);
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("크루스칼.txt"));
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		ArrayList<Edge> edges = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(edges);
		//순환 겸사를 위해 서로스를  구현한다
		//makeset - find  - union
		parents = new int[V];
		
		for (int i = 0; i < parents.length; i++) {
			parents[i]=i;
		}
		
		//edges 간선을 하나씩 가져와서 순환이 없다면 간선을 선택한다.
		//선택된 간선의 cost의 합을 저장하는 변수
		int sum=0,cnt=0;
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			if(find(edge.s)!=find(edge.e)) {
				union(edge.s,edge.e);
				cnt++;
				sum+=edge.c;
				if(cnt==V-1) break;
			}
		}
		System.out.println(sum);
	}
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa!=pb) {
			parents[pa]=pb;
		}
		
	}
	private static int find(int s) {
		if(parents[s]==s) return s;
		//path compression
		else return parents[s]=find(parents[s]);
	}
}
