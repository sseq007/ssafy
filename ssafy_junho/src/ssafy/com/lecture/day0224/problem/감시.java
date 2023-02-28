package ssafy.com.lecture.day0224.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import ssafy.com.lecture.day0224.problem.감시.Point;

public class 감시 {
	static class Point{
		int x,y,type;

		public Point(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
		
	}
	static int[][][] dir = { 
			
	};
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,1};
	static int n,m;
	static int[][] map;
	static ArrayList<Point> camera;
	static StringTokenizer st;
	static int zero_count;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		camera = new ArrayList<Point>();
		zero_count=n*m;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) zero_count--;
				else if(map[i][j]>=1&&map[i][j]<=5) {
					camera.add(new Point(i, j, map[i][j]));
				}
				
			}
		}
		
		recur(0);
		
	}
	private static void recur(int idx) {
		if(idx == camera.size()) {
			return;
		}
		
//		for(int i=0;i<ar)
		
	}
}
