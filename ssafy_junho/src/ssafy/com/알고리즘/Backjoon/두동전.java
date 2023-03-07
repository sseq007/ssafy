package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//사방을 백트래킹
public class 두동전 {
	static class Point{
		int x,y;
		boolean fall;
		public Point(int x, int y, boolean fall) {
			super();
			this.x = x;
			this.y = y;
			this.fall = fall;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", fall=" + fall + "]";
		}
		
		
	}
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int n,m;
	static char[][] map;
	static boolean[][] v;
	static Queue<Point> q  = new LinkedList<Point>();
	static StringTokenizer st;
	static int min_cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		map= new char[n][m];
		v= new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=st.nextToken().charAt(0);
				if(map[i][j]=='o') q.add(new Point(i, j,false));
			}
		}
		
		
		
		while(!q.isEmpty()) {
			for (int s = 0; s < q.size(); s++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					
				}
			}
		}
		
		
		
	}
}
