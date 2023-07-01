package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 1926
public class 그림 {
	static int n,m;
	static int cnt,picture_cnt,max_cnt=Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v= new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		picture_cnt=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!v[i][j]&&map[i][j]==1) {
					cnt=1;
					dfs(i,j,cnt);
					picture_cnt++;
					max_cnt=Math.max(max_cnt, cnt);
				}
			}
		}
		if(picture_cnt==0) {
			System.out.println(0);
			System.out.println(0);
		}else {
			
			System.out.println(picture_cnt);
			System.out.println(max_cnt);
		}
		
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	private static void dfs(int x, int y, int val) {
		
		cnt=Math.max(val, cnt);
		
		v[x][y]=true;
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0>nx||0>ny||nx>=n||ny>=m) continue;
			if(!v[nx][ny]&&map[nx][ny]==1) {
				dfs(nx, ny, cnt+1);
			}
		}
		
	}
}
