package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

//BOJ 14620
public class 꽃길 {
	static int n,sum_cost;
	static int min_cost = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] v;
	static StringTokenizer st;
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
		dfs(0,0);
		System.out.println(min_cost);
	}
	private static void dfs(int idx, int sum) {
		if(idx==3) {
			min_cost = Math.min(sum,min_cost);
			return;
		}
		
		for (int i = 1; i < n-1; i++) {
			for (int j = 1; j < n-1; j++) {
				if(!v[i][j]&&check(i,j)) {
					//방문처리
					v[i][j]=true;
					sum_cost=0;
					sum_val(i,j);
					dfs(idx+1, sum+sum_cost);
					revisit(i,j);
					v[i][j]=false;
					
				}
			}
		}
		
		
		
	}
	private static void revisit(int x, int y) {
		
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(v[nx][ny]) {
				v[nx][ny]=false;
			}
		}
		
	}
	private static void sum_val(int x, int y) {
		
		sum_cost+=map[x][y];
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			sum_cost+=map[nx][ny];
			v[nx][ny]=true;
		}
		
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	private static boolean check(int x, int y) {
		
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(v[nx][ny]) return false;
		}
		return true;
	}

}
