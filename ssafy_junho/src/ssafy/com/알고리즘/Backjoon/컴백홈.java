package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컴백홈 {
	static int n,m,k,anw;
	static char[][] map;
	static boolean[][] v;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j]=input.charAt(j);
			}
		}
		v[n-1][0]=true;
		dfs(n-1,0,1);
		System.out.println(anw);
	}
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	private static void dfs(int x, int y, int cnt) {
		if(cnt==k) {
			 if(x==0&&y==m-1) {
				 
				 anw++;
			 }
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0>nx||0>ny||nx>=n||ny>=m) continue;
			if(v[nx][ny]) continue;
			if(map[nx][ny]=='.') {
				v[nx][ny]=true;
				dfs(nx, ny, cnt+1);
				v[nx][ny]=false;
			}
		}
		
	}
}
