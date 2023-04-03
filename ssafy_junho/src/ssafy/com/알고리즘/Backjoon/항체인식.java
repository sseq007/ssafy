package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 항체인식 {
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
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int n,m,cnt,cnum,bnum;
	static String anw= "YES";
	static int[][] a_map;
	static int[][] b_map;
	static boolean[][] v;
	static ArrayList<Point> list;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a_map= new int[n][m];
		b_map= new int[n][m];
		v= new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				a_map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				b_map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		loop:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!v[i][j]&&a_map[i][j]!=b_map[i][j]) {
					bnum = a_map[i][j];
					cnum = b_map[i][j];
					bfs(i,j);
//					print(a_map);
					break loop;
					
				}
			}
		}
		
		if(!check()) {
			anw = "NO";
		}
				
		System.out.println(anw);
		
		
		
		
	}
	private static void print(int[][] a_map) {
		for (int i = 0; i < a_map.length; i++) {
			for (int j = 0; j < a_map[i].length; j++) {
				System.out.print(a_map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(a_map[i][j]!=b_map[i][j]) return false;
			}	
		}
		return true;
	}
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		v[x][y]=true;
		a_map[x][y]=cnum;
//		list = new ArrayList<>();
//		list.add(new Point(x, y));
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				if(0>nx||0>ny||nx>=n||ny>=m) continue;
				if(v[nx][ny]) continue;
				if(a_map[nx][ny]==bnum) {
					v[nx][ny]=true;
					q.add(new Point(nx, ny));
					a_map[nx][ny]=cnum;
//					list.add(new Point(nx, ny));
				}
			}
		}
	}
}

//	private static int check(Point p) {
//		int x = p.x;
//		int y = p.y;
//		if(a_map[x][y]!=b_map[x][y]) {
//			return 1;
//		}else {
//			
//			return 2;
//		}
//		
//	}