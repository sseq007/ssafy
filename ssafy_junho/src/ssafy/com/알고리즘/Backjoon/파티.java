package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//BOJ 1238
public class 파티 {

	static class Point implements Comparable<Point>{
		int node,val;

		public Point(int node, int val) {
			super();
			this.node = node;
			this.val = val;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.val, o.val);
		}
	}
	static int n,m,x,max_time = Integer.MIN_VALUE;
	static List<Point>[] graph1;
	static List<Point>[] graph2;
	static int[] dist;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x= Integer.parseInt(st.nextToken());
		graph1 = new List[n+1];
		graph2 = new List[n+1];
		for (int i = 1; i <=n ; i++) {
			graph1[i]= new ArrayList<Point>();
			graph2[i]= new ArrayList<Point>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int val= Integer.parseInt(st.nextToken());
			
			graph1[a].add(new Point(b, val));
			graph2[b].add(new Point(a, val));
			
		}
		
		int[] dist1 = dik(graph1);
		int[] dist2 = dik(graph2);
		
		for (int i = 1; i <=n ; i++) {
			int total=0;
			total = dist1[i]+dist2[i];
			max_time=Math.max(total, max_time);
		}
		System.out.println(max_time);
		
	}
	private static int[] dik(List<Point>[] graph) {
		
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		boolean v[]  = new boolean[n+1];
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[x]=0;
		q.add(new Point(x, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(!v[p.node]) {
				v[p.node]=true;
				
				for (Point next :graph[p.node] ) {
					if(!v[next.node]&&dist[next.node]>dist[p.node]+next.val) {
						dist[next.node]=dist[p.node]+next.val;
						q.add(new Point(next.node, dist[next.node]));
					}
				}
			}
			
		}
		return dist;
	}
}
