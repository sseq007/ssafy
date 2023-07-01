package ssafy.com.알고리즘.a형막트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 프로세서 {

	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int n,min_sum;
	static ArrayList<Point> arr;
	static int[][] map;
	static boolean[] sel;
 	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			n  = Integer.parseInt(br.readLine());
			map = new int[n][n];
			arr = new ArrayList<Point>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]==1&&check(i,j)) {
						arr.add(new Point(i, j));
					}
				}
			}
			min_sum =Integer.MAX_VALUE;
			for (int i = arr.size(); i >=1 ; i--) {
				sel = new boolean[arr.size()];
				comb(0,0,i);
				if(min_sum!=Integer.MAX_VALUE) {
					break;
				}
			}
			
			System.out.println("#"+tc+" "+min_sum);
			}
		}
	private static void comb(int idx, int s, int size) {
		if(idx==size) {
//			System.out.println(Arrays.toString(sel));
			recur(0,0);
			return;
		}
		
		for (int i = s; i < sel.length; i++) {
			sel[i]=true;
			comb(idx+1, i+1, size);
			sel[i]=false;
		}
	}
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	private static void recur(int idx, int cnt) {
		if(idx==arr.size()) {
			min_sum=Math.min(min_sum, cnt);
			return;
		}
		
		if(!sel[idx]) {
			recur(idx+1, cnt);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nx = arr.get(idx).x;
			int ny = arr.get(idx).y;
			int cnt2=0;
			boolean flag = false;
			while(true) {
				nx = nx+dx[d];
				ny = ny +dy[d];
				if(0>nx||0>ny||nx>=n||ny>=n) {
					flag = true;
					break;
				}
				if(map[nx][ny]!=0) break;
				cnt2++;
				map[nx][ny]=2;
			}
			
			if(flag) {
				recur(idx+1, cnt+cnt2);
			}
			while(true) {
				nx-=dx[d];
				ny-=dy[d];
				if(nx==arr.get(idx).x&&ny==arr.get(idx).y) {
					break;
				}
				map[nx][ny]=0;
			}
			
		}
		
	}
	private static boolean check(int x, int y) {
		if(x==0||x==n-1||y==0||y==n-1) {
			return false;
		}
		return true;
	}
		

}
