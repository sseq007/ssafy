package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 텔레포트정거장 {

	static class Point{
		int idx,cnt;

		public Point(int idx, int cnt) {
			super();
			this.idx = idx;
			this.cnt = cnt;
		}

		public Point(int idx) {
			super();
			this.idx = idx;
		}
		
	}
	static int n,m,s,e,time;
	static List<Point>[] graph;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		graph = new List[n+1];
		for (int i = 1; i <=n; i++) {
			graph[i]= new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(new Point(b));
			graph[b].add(new Point(a));
		}
		time = Integer.MAX_VALUE;
		bfs();
		System.out.println(time);
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(s, 0));
		boolean[] v = new boolean[n+1];
		v[s]=true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.idx==e) {
				time  = Math.min(time, p.cnt);
				return;
			}
			for (int i = 0; i < graph[p.idx].size(); i++) {
				Point next = graph[p.idx].get(i);
				if(v[next.idx]) continue;
				v[next.idx]=true;
				q.add(new Point(next.idx, p.cnt+1));
			}
			int next_left = p.idx-1;
			int next_right = p.idx+1;
			if(next_left>=1&&!v[next_left]) {
				v[next_left]=true;
				q.add(new Point(next_left, p.cnt+1));
			}
			if(next_right<n+1&&!v[next_right]) {
				v[next_right]=true;
				q.add(new Point(next_right, p.cnt+1));
			}
			
		}
		
	}
}
