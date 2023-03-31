package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기 {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int n,bear_n;
	static List<Integer>[] list;
	static int[][] info;
	
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			info = new int[n+2][2];
			list = new ArrayList[n+2];
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j <2 ; j++) {
					info[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < n+2; i++) {
				list[i]= new ArrayList<Integer>();
			}
			for (int i = 0; i < n+1; i++) {
				for (int j = i; j <n+2 ; j++) {
					
				}
			}
			
			bfs();
		}
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		
	}
}
