package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지 {
	static class Point implements Comparable<Point>{
		int x,y,val;

		public Point(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.val, o.val);
		}
		
	}
	static int n,anw,num;
	static int[][] map;
	static int[][] dist;
	static boolean[][] v;
 	static StringTokenizer st;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num=1;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0) {
				break;
			}
			map = new int[n][n];
			dist = new int[n][n];
			anw = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			System.out.printf("Problem %d: %d\n",num,anw);
			num++;
		}
	}
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	private static void bfs() {
		Queue<Point> q = new PriorityQueue<>();
		q.add(new Point(0, 0, map[0][0]));
		v = new boolean[n][n];
		v[0][0]=true;
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x==n-1&&p.y==n-1) {
				anw = p.val;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				if(0<=nx&&0<=ny&&nx<n&&ny<n&&!v[nx][ny]) {
					
					if(p.val+map[nx][ny]<dist[nx][ny]) {
						dist[nx][ny]=p.val+map[nx][ny];
						q.add(new Point(nx, ny, dist[nx][ny]));
					}
				}
			}
		}
	}
}
