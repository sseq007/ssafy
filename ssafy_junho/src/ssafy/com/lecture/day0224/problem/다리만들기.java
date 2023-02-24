package ssafy.com.lecture.day0224.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 육지 개수 찾기 
 * 육지마다 다리를 이을수 있는 경우 해보기
 * 
 * */
public class 다리만들기 {
	static class Point{
		int x,y,cnt;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
		

	}
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n,land_num;
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] v;
	static int anw=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		v = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		land_num=0;
		//섬 구분 짓기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]==1&&!v[i][j]) {
					bfs(i,j,land_num+1);
					land_num++;
				}
			}
		}
		for (int k = 1; k <= land_num; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					
					if (map[i][j] == k) {
						v = new boolean[n][n];
						bfs2(i, j,k);
					}

				}
			}
		}

		System.out.println(anw);

//		print();
		
		
	}
	private static void bfs2(int x, int y,int k) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y,0));
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (0 > nx || nx >= n || 0 > ny || ny >= n)
					continue;
				if(map[nx][ny]!=0&&map[nx][ny]!=k) {
					anw = Math.min(anw, p.cnt);
					return;
				}
				if (v[nx][ny])
					continue;

				if (map[nx][ny] == 0) {
					v[nx][ny] = true;
					q.add(new Point(nx, ny, p.cnt + 1));
				}
			}
		}
	}

	private static void bfs(int x, int y,int num) {
		Queue<Point> q = new LinkedList<Point>();
		v[x][y]=true;
		map[x][y]=num;
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d=0;d<4;d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				if(0<=nx&&nx<n&&0<=ny&&ny<n&&!v[nx][ny]&&map[nx][ny]==1) {
					v[nx][ny]=true;
					map[nx][ny]=num;
					q.add(new Point(nx, ny));
				}
				
			}
		}
		
	}
	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
