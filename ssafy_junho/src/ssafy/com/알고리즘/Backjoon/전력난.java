package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전력난 {

	static class Point implements Comparable<Point>{
		int idx,val;

		public Point(int idx, int val) {
			super();
			this.idx = idx;
			this.val = val;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.val, o.val);
		}
		
	}
	static int n,m;
	static List<Point>[] graph;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n==0&&m==0) System.exit(0);
			graph = new List[n];
			for (int i = 0; i < n; i++) {
				graph[i]= new ArrayList<Point>();
			}
			int cost=0;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				int c= Integer.parseInt(st.nextToken());
				graph[a].add(new Point(b, c));
				graph[b].add(new Point(a, c));
				cost+=c;
			}
			PriorityQueue<Point> q = new PriorityQueue<Point>();
			boolean[] v = new boolean[n];
			q.add(new Point(0, 0));
			int result=0;
			int cnt=0;
			while(!q.isEmpty()) {
				Point p = q.poll();
				if(v[p.idx]) continue;
				v[p.idx]=true;
				result+=p.val;
				if(cnt==n) break;
				for (int i = 0; i < graph[p.idx].size(); i++) {
					Point next = graph[p.idx].get(i);
					if(v[next.idx]) continue;
					q.add(next);
				}
				
			}
			System.out.println(cost-result);
		}
		}
}
