package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 내리막길 {
	
	
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int n,m,cnt;
	static int[][] map;
	static boolean[][] v;
	static int[][] memo;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map= new int[n][m];
		memo= new int[n][m];
		
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
//		print(memo);
		System.out.println(dfs(0, 0));
	}

	private static void print(int[][] memo) {
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[i].length; j++) {
				System.out.print(memo[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int dfs(int x, int y) {
//		print(memo);
		if(x==n-1&&y==m-1) {
			
			return 1;
		}
		if(memo[x][y]!=-1) {
			return memo[x][y];
		}
		memo[x][y]=0;
		
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0>nx||0>ny||nx>=n||ny>=m) continue;
			if(map[x][y]<=map[nx][ny]) continue;
			
			memo[x][y]+=dfs(nx, ny);
		}
		return memo[x][y];
	}
}
