package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 현수막 {
	static int[] dx= {-1,0,1,0,-1,1,1,-1};
	static int[] dy= {0,1,0,-1,1,1,-1,-1};
	static int m,n,cnt;
	static int[][] map;
	static boolean[][] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map= new int[m][n];
		v= new boolean[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]==1&&!v[i][j]) {
					v[i][j]=true;
					dfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	private static void dfs(int x, int y) {
		
		for (int d = 0; d < 8; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0<=nx&&0<=ny&&nx<m&&ny<n&&!v[nx][ny]&&map[nx][ny]==1) {
				v[nx][ny]=true;
				dfs(nx, ny);
			}
		}
		
	}
}
