package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모양만들기 {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int n,m,cnt,max_cnt;
	static int[][] map;
	static boolean[][] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map= new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==0) {
					v= new boolean[n][m];
					cnt=0;
					map[i][j]=1;
					v[i][j]=true;
					dfs(i,j);
					map[i][j]=0;
//					v[i][j]=false;
//					System.out.println(cnt);
					max_cnt=Math.max(cnt, max_cnt);
				}
			}
		}
		System.out.println(max_cnt);
		
		
	}
	private static void dfs(int x, int y) {
		cnt++;
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0<=nx&&0<=ny&&nx<n&&ny<m&&!v[nx][ny]&&map[nx][ny]==1) {
				v[nx][ny]=true;
//				print(v);
				dfs(nx, ny);
//				v[nx][ny]=false;
			}
		}
	}
	private static void print(boolean[][] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}
}
