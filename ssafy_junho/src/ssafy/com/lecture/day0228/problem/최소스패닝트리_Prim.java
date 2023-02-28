package ssafy.com.lecture.day0228.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import ssafy.com.lecture.day0228.problem.최소스패닝트리_Prim.Edge;


public class 최소스패닝트리_Prim  {

	static int v,e;
	static long sum;
	static StringTokenizer st;
	static ArrayList<Edge>[] edges;
	static boolean[] visited;
	static class Edge implements Comparable<Edge>{
		int e,c;

		public Edge(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.c, o.c);
		}
		
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in))) ;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			visited = new boolean[v+1];
			edges = new ArrayList[v+1];
			for (int i = 1; i < edges.length; i++) {
				edges[i]= new ArrayList<Edge>();
			}
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edges[a].add(new Edge(b, c));
				edges[b].add(new Edge(a, c));
				
			}
			sum=0;
			PriorityQueue<Edge> q = new PriorityQueue<Edge>();
			q.add(new Edge(1, 0));
			
			while(!q.isEmpty()) {
				Edge p = q.poll();
				
				if(!visited[p.e]) {
					visited[p.e]=true;
					sum+=p.c;
					
					Iterator<Edge> iter = edges[p.e].listIterator();
					while(iter.hasNext()) {		
						q.add(iter.next() );
					}
				}
			}
			
			System.out.println("#"+tc+" "+sum);
		}
		
	}
	
}
