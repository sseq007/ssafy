package ssafy.com.lecture.day0303.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import ssafy.com.lecture.day0303.problem.산악구조.Point;


public class 산악구조 {
	static int[][] map;
	static int n,min;
	static boolean[][] v;
	static int[][] dist;
	static StringTokenizer st;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
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

		
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			v = new boolean[n][n];
			dist = new int[n][n];
			min = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			dijkstra();
			System.out.println(min);
		}
	}


	private static void dijkstra() {
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.add(new Point(0, 0, 0));
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0]=0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			v[p.x][p.y]=true;
			if(p.x==n-1&&p.y==n-1) {
				min = p.val;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				if(0<=nx&&nx<n&&0<=ny&&ny<n&&!v[nx][ny]) {
					int fuel=0;
					if(map[nx][ny]>map[p.x][p.y]) {
						fuel= Math.abs(map[nx][ny]-map[p.x][p.y])*2;
					}else if(map[nx][ny]==map[p.x][p.y]) {
						fuel=1;
					}else {
						fuel=0;
					}
					if(p.val+fuel<dist[nx][ny]) {
						dist[nx][ny]=p.val+fuel;
						q.add(new Point(nx, ny, p.val+fuel));
					}
					
					
					
				}
			}
			
			
		}
		
	}
	
	
}
