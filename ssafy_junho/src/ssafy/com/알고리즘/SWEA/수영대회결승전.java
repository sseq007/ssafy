package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 수영대회결승전 {
	static class Point{
		int x,y,second;

		public Point(int x, int y, int second) {
			super();
			this.x = x;
			this.y = y;
			this.second = second;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", second=" + second + "]";
		}
		
	}
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int n,a,b,c,d,anw;
	static int[][] map;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			n = Integer.parseInt(br.readLine());
			map= new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			anw = -1;
			bfs(a,b);
			
			System.out.println("#"+tc+" "+anw);
		}
		
	}
	private static void bfs(int x, int y) {
		Queue<Point>  q= new LinkedList<>();
		boolean[][] v = new boolean[n][n];
		q.add(new Point(x, y, 1));
		v[x][y]=true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			System.out.println(p.toString());
			if(p.x==c&&p.y==d) {
//				System.out.println(p.second);
				anw = p.second-1;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				if(0>nx||0>ny||nx>=n||ny>=n) continue;
				if(v[nx][ny]) continue;
				if(map[nx][ny]==1) continue;
				if(map[nx][ny]==2) {
					if(p.second<3||p.second%3!=0) {
						q.add(new Point(p.x, p.y, p.second+1));
						continue;
					}
				}
				v[nx][ny]=true;
				q.add(new Point(nx, ny, p.second+1));
				
			}
		}
	}
	
}
