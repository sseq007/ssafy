package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 1303
public class 전쟁_전투 {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;

		}
		
	}
	static int n,m,w,b,totalw,totalb;
	static char[][] map;
	static boolean[][] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j]=input.charAt(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]=='W'&&!v[i][j]) {
					w=1;
					bfs(i, j,map[i][j]);
					totalw+=Math.pow(w, 2);
				}else if(map[i][j]=='B'&&!v[i][j]) {
					b=1;
					bfs(i,j,map[i][j]);
					totalb+=Math.pow(b, 2);
				}
			}
		}
		System.out.printf("%d %d",totalw,totalb);
		
		
	}
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,-0,1,-1};
	
	private static void bfs(int x, int y, char val) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		v[x][y]=true;
		
		while(!q.isEmpty()) {
				Point p = q.poll();
				if(val=='W') {
					for (int d = 0; d < 4; d++) {
						int nx = p.x+dx[d];
						int ny = p.y+dy[d];
						if(0<=nx&&0<=ny&&nx<n&&ny<m&&!v[nx][ny]&&map[nx][ny]=='W') {
							w++;
							v[nx][ny]=true;
							q.add(new Point(nx, ny));
						}
					}
				}else {
					for (int d = 0; d < 4; d++) {
						int nx = p.x+dx[d];
						int ny = p.y+dy[d];
						if(0<=nx&&0<=ny&&nx<n&&ny<m&&!v[nx][ny]&&map[nx][ny]=='B') {
							b++;
							v[nx][ny]=true;
							q.add(new Point(nx, ny));
						}
					}
					
				}
			
		}
		
	}

	
}
