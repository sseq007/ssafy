package ssafy.com.lecture.day0303.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 프로세서연결하기 {
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
	static int map[][];
	static int n,min;
	static boolean[] sel;
	static ArrayList<Point> arr;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			arr = new ArrayList<Point>();
			min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]==1&&check(i,j)) {
						arr.add(new Point(i, j));
					}
					
				}
			}
			
			
			for(int i=arr.size();i>=1;i--) {
				sel = new boolean[arr.size()];

				comb(0,0,i);
				if(min<Integer.MAX_VALUE) break;
				
			}
			
			System.out.println("#"+tc+" "+min);
			
		}
	}
	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
		
	}
	private static void comb(int idx, int s,int size) {
		if(idx==size) {
//			System.out.println(Arrays.toString(sel));
			recur(0,0);
			return;
		}
		
		for (int i = s; i < sel.length; i++) {
				sel[i]=true;
				comb(idx+1, i+1,size);
				sel[i]=false;
				
		}
		
		
	}
	private static void recur(int idx,int cnt) {
		if(idx==arr.size()) {
			min = Math.min(cnt, min);
			return;
		}
		
		if(!sel[idx]) {
			recur(idx+1, cnt);
			return;
		}
		
		//오른쪽
		for (int d = 0; d < 4; d++) {
			boolean flag = false;
			int cnt2=0;
			int nx = arr.get(idx).x;
			int ny = arr.get(idx).y;
			while(true) {
				nx += dx[d];
				ny += dy[d];
				if(0>nx||0>ny||nx>=n||ny>=n) {
					flag = true;
					break;
				}
				
				if(map[nx][ny]!=0) break; 
				cnt2++;
				map[nx][ny]=2;
				
			}
//			print();
			if(flag) {
				recur(idx+1, cnt+cnt2);
			}
			while(true) {
				nx-=dx[d];
				ny-=dy[d];
				if(nx==arr.get(idx).x&&ny==arr.get(idx).y) break;
				map[nx][ny]=0;
				
			}
		}
		
	}
	private static boolean check(int x, int y) {
		if(x==0||x==n-1||y==0||y==n-1) return false;
		return true;
	}
}
