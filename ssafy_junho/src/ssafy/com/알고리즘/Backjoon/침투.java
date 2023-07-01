package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 13565
public class 침투 {

	static int n,m;
	static int[][] map;
	static boolean[][] v;
	static String anw = "NO";
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j]=input.charAt(j)-'0';
			}
		}
		for (int i = 0; i < m; i++) {
				if(map[0][i]==0&&!v[0][i]) {
					dfs(0,i);
			}
		}
		
		System.out.println(anw);
	}
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,-1,1};
	private static void dfs(int x, int y) {
		if(innerCheck(x,y)) {
			anw="YES";
			return;
		}
		
		v[x][y]=true;
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0<=nx&&nx<n&&0<=ny&&ny<m&&!v[nx][ny]&&map[nx][ny]==0) {
				dfs(nx, ny);
			}
		}
	}
	private static boolean innerCheck(int x, int y) {
		for (int i = 0; i < m; i++) {
			if(x==n-1&&y==i) {
				return true;
			}
		}
		return false;
	}
	
}
