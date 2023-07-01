package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
	
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
	static int V,E;
	static List<Point>[]list;
	static boolean[] v;
	static PriorityQueue<Point> q;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new List[V+1];
		v = new boolean[V+1];
		q = new PriorityQueue<>();
		for (int i = 1; i <=V; i++) {
			list[i] =  new ArrayList<Point>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Point(b, c));
			list[b].add(new Point(a, c));
		}
		long result = 0;
		int cnt = 1;
		q.add(new Point(1, 0));
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(v[p.idx]) continue;
			result += p.val;
			v[p.idx]=true;
			cnt++;
			if(cnt==V+1) break;
			for (int i = 0; i < list[p.idx].size(); i++) {
				Point next = list[p.idx].get(i);
				if(v[next.idx]) continue;
				q.add(next);
			}
		}
		System.out.println(result);
	}
}
