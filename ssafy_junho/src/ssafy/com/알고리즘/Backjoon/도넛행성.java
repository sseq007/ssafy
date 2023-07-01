package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 도넛행성 {

	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}
	static int n,m;
	static int[][] map;
	static boolean[][] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==0&&!v[i][j]) {
					cnt++;
					bfs(i,j);
				}
			}
		}
		System.out.println(cnt);
		
		
	}
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	private static void bfs(int x, int y) {
		Queue<Point> q= new LinkedList<>();
		q.add(new Point(x, y));
		v[x][y] =true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				//범위가 벗어나면
				if(0>nx) {
					nx=n-1;
				}else if(0>ny) {
					ny= m-1;
				}else if(nx>=n) {
					nx=0;
				}else if (ny>=m) {
					ny=0;
				}
				//방문을 했으면
				if(v[nx][ny]) continue;
				//0이면
				if(map[nx][ny]==0) {
					v[nx][ny]=true;
					q.add(new Point(nx, ny));
				}
			}
		}
	}
}
