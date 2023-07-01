package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import ssafy.com.알고리즘.Backjoon.최소비용구하기.Point;

//BOJ 1916
public class 최소비용구하기 {

	static class Point implements Comparable<Point> {
		int x, val;

		public Point(int x, int val) {
			super();
			this.x = x;
			this.val = val;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.val, o.val);
		}

	}

	static int n, m, start, end;
	static List<Point>[] graph;
	static int[] dist;
	static StringTokenizer st;
	private static Point poll;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		graph = new List[n + 1];
		dist = new int[n + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<Point>();

		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[a].add(new Point(b, v));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		PriorityQueue<Point> q = new PriorityQueue<>();
		boolean[] v = new boolean[n + 1];
		dist[start] = 0;
		q.add(new Point(start, 0));

		while (!q.isEmpty()) {
			Point p = q.poll();
			if (!v[p.x]) {
				v[p.x] = true;
				for (Point next : graph[p.x]) {
					if (!v[next.x] && dist[next.x] > dist[p.x] + next.val) {
						dist[next.x] = dist[p.x] + next.val;
						q.add(new Point(next.x, dist[next.x]));
					}
				}
			}
		}
		System.out.println(dist[end]);
	}
}
