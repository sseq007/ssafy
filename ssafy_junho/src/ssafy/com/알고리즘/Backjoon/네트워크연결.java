package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 네트워크연결 {
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
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<Point>[]graph= new List[n+1];
		for (int i = 1; i <=n; i++) {
			graph[i]=new ArrayList<Point>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			graph[a].add(new Point(b, c));
			graph[b].add(new Point(a, c));
		}
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		boolean[] v = new boolean[n+1];
		q.add(new Point(1, 0));
		int cnt=1;
		int result=0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(v[p.idx]) continue;
			v[p.idx]=true;
			cnt++;
			result+=p.val;
			if(cnt==n+1) break;
			for (int i = 0; i < graph[p.idx].size(); i++) {
				Point next = graph[p.idx].get(i);
				if(v[next.idx]) continue;
				q.add(next);
			}
		}
		System.out.println(result);
		
	}
}
