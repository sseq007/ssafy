package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 돌다리 {
	static class Point{
		int x,cnt;

		public Point(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}
		
	}
	static int a,b,n,m;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		map.put(1, -1);
		map.put(2, a);
		map.put(3, -a);
		map.put(4, b);
		map.put(5, -b);
		map.put(6, a);
		map.put(7, b);
		int min= Integer.MAX_VALUE;
		Queue<Point> q = new LinkedList<Point>();
		boolean[] v = new boolean[100001];
		q.add(new Point(n, 0));
		v[n]=true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x==m) {
				min=p.cnt;
				break;
			}
			for (int key : map.keySet()) {
				int val = map.get(key);
				int next;
				if(key==6||key==7) {
					 next = p.x*val;
				}
				else {
					 next = p.x+val;
				}
				
				if(next<0||next>=100001) continue;
				if(v[next]) continue;
				v[next]=true;
				
				q.add(new Point(next, p.cnt+1));
				
				
				
			}
		}
		System.out.println(min);
	}
}
