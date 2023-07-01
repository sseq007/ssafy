package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시분할계획 {

	static class Point implements Comparable<Point>{
		int idx,val;

		public Point(int idx, int val) {
			super();
			this.idx = idx;
			this.val = val;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.val, o.val);
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Point>[] graph = new List[n+1];
		for (int i = 1; i <=n; i++) {
			graph[i] = new ArrayList<Point>();
 		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Point(b, c));
			graph[b].add(new Point(a, c));
		}
		int cnt=1;
		int result=0;
		int max=0;
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		q.add(new Point(1, 0));
		boolean[] v = new boolean[n+1];
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(v[p.idx]) continue;
			v[p.idx]=true;
			cnt++;
			result+=p.val;
			max = Math.max(max, p.val);
			if(cnt==n+1) break;
			for (int i = 0; i <graph[p.idx].size() ; i++) {
				Point next = graph[p.idx].get(i);
				if(v[next.idx]) continue;
				q.add(next);
			}
			
		}
		System.out.println(result-max);
	}
}
