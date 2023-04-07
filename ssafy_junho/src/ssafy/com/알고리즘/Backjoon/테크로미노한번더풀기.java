package ssafy.com.알고리즘.Backjoon;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class 테크로미노한번더풀기 {
	static int n,m;
	static int max_sum = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				v[i][j]=true;
				dfs(i,j,0,map[i][j]);
				v[i][j]=false;
			}
		}
		System.out.println(max_sum);
		
	}
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	private static void dfs(int x, int y, int idx, int sum) {
		if(idx==3) {
			max_sum=Math.max(max_sum, sum);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0<=nx&&0<=ny&&nx<n&&ny<m&&!v[nx][ny]) {
				if(idx==1) {
					v[nx][ny]=true;
					dfs(x, y, idx+1, sum+map[nx][ny]);
					v[nx][ny]=false;
					
				}
				v[nx][ny]=true;
				dfs(nx, ny, idx+1, sum+map[nx][ny]);
				v[nx][ny]=false;
			}
		}
		
		
	}
}
