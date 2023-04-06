package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 진우의민트초코우유 {
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
	static int n,m,h,anw,milk_n,m2;
	static int start_x,start_y,next_x,next_y;
	static int[][] map;
	static ArrayList<Point> milk;
	static boolean[] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map= new int[n][n];
		milk = new ArrayList<Point>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					start_x=i;
					start_y=j;
				}
				if(map[i][j]==2) {
					milk_n++;
					milk.add(new Point(i, j));
				}
			}
		}
		v= new boolean[milk_n];
		int[] sel = new int[milk_n];
		anw = 0;
		recur(0,sel);
		System.out.println(anw);
	}

	private static void recur(int idx,int sel[]) {
		if (idx == sel.length) {
			System.out.println(Arrays.toString(sel));
			logic(sel);
			return;
		}
		//민트초코 순열 구하기
		for (int i = 0; i < milk.size(); i++) {
			if(!v[i]) {
				v[i]=true;
				sel[idx]=i;
				recur(idx+1,sel);
				v[i]=false;
			}
		}
		
	}
	
	
	private static void logic(int[] sel) {
		
		int milk_x = start_x;
		int milk_y = start_y;
		int H = m;
		int idx=0;
		for (int i = 0; i < sel.length; i++) {
			Point now = milk.get(sel[i]);
			int dist_home = Math.abs(start_x-now.x)+Math.abs(start_y-now.y);
			int dist_milk = Math.abs(milk_x-now.x)+Math.abs(milk_y-now.y);
			if(H>=dist_milk) {
				H-=dist_milk;
				H+=h;
				idx++;
				if(H>=dist_home) {
					if(anw<idx) {
						anw = idx;
					}
				}
				milk_x=now.x;
				milk_y=now.y;
				
			}else {
				return;
			}
		}
		
		
	}

	private static void print(Point[] sel2) {
		for (int i = 0; i < sel2.length; i++) {
			System.out.print(sel2[i].toString());
		}
		System.out.println();
	}
	
	
}
