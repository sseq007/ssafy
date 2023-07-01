package ssafy.com.알고리즘.a형막트.실전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 파핑파핑지뢰찾기 {

	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int n,cnt;
	static char[][] map;
	static int[] dx= {1,-1,0,0,1,1,-1,-1};
	static int[] dy= {0,0,1,-1,1,-1,1,-1};
	static boolean[][] v;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			v = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j]=input.charAt(j);
				}
			}
			find_mine();
			cnt=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]=='0'&&!v[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]!='*'&&!v[i][j]) {
						cnt++;
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
			
		}
	}
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y));
		v[x][y]=true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 8; d++) {
				int nx =p.x+dx[d];
				int ny =p.y+dy[d];
				if(0<=nx&&0<=ny&&nx<n&&ny<n&&!v[nx][ny]&&map[nx][ny]!='*') {
					v[nx][ny]=true;
					if(map[nx][ny]=='0') {
						
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}
	private static void find_mine() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]=='.') {
					int cnt=0;
					for (int d = 0; d < 8; d++) {
						int nx =i+dx[d];
						int ny =j+dy[d];
						if(0<=nx&&0<=ny&&nx<n&&ny<n&&map[nx][ny]=='*') {
							cnt++;
						}
					}
					map[i][j]=(char) (cnt+'0');
				}
			}
		}
		
		
	}
}
