package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어2 {
	static class Point{
		int x,y,cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int n,m,max_dis=Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map= new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==0) {
					v = new boolean[n][m];
					bfs(i,j);
				}
			}
		}
		System.out.println(max_dis);
		
	}
	static int[] dx= {0,0,1,-1,-1,1,1,-1};
	static int[] dy= {1,-1,0,0,1,1,-1,-1};
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y, 0));
		v[x][y]=true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(map[p.x][p.y]==1&&p.cnt!=0) {
				max_dis=Math.max(max_dis, p.cnt);
				break;
			}
			for (int d = 0; d < 8; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				if(0>nx||0>ny||nx>=n||ny>=m)continue;
				if(v[nx][ny]) continue;
				v[nx][ny]=true;
				
				q.add(new Point(nx, ny, p.cnt+1));
			}
		}
	}
}
