package ssafy.com.lecture.day0215.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 치즈도둑 {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[][] map;
	static boolean[][]v;
	static StringTokenizer st;
	static int n;
	static int max;
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			max = Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int day=0;day<=100;day++) {
				v = new boolean[n][n];
				int cnt=0;
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(map[i][j]==day) {
							map[i][j]=0;
							v[i][j]=true;
						}
					}
				}
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(map[i][j]!=0&&!v[i][j]) {
							cnt++;
							dfs(i,j);
							
						}
					}
				}
				max = Math.max(cnt, max);
			}
			
			System.out.println("#"+tc+" "+max);
			
		}
	}
	private static void dfs(int x,int y) {

		
		v[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nr = x+dr[i];
			int nc = y+dc[i];
			if(0<=nr&&nr<n&&0<=nc&&nc<n&&!v[nr][nc]&&map[nr][nc]!=0) {
				
				dfs(nr, nc);
				
			}
		}
	}
}
