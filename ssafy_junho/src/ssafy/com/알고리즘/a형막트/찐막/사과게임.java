package ssafy.com.알고리즘.a형막트.찐막;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사과게임 {

	static int n,max_apple,min_turn;
	static int[][] map;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			max_apple=0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]>0) max_apple++;
				}
			}
			min_turn=Integer.MAX_VALUE;
			dfs(0,0,0,0,1);
			System.out.println("#"+tc+" "+min_turn);
		}
	}
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	private static void dfs(int x, int y, int d, int cnt, int eat) {
		if(max_apple==eat-1) {
			min_turn=Math.min(min_turn, cnt);
			return;
		}
		
		int nx = x+dx[d];
		int ny = y+dy[d];
		
		if(check(x,y,d,eat)||(0>nx||0>ny||nx>=n||ny>=n)) {
			d = (d+1)%4;
			dfs(x, y, d, cnt+1, eat);
			return;
		}
		
		if(map[x][y]==eat) {
			dfs(x, y, d, cnt, eat+1);
		}else {
			dfs(nx, ny, d, cnt, eat);
		}
		
	}
	private static boolean check(int x, int y, int d, int eat) {
		d = (d+1)%4;
		
		while(0<=x&&0<=y&&x<n&&y<n) {
			x+=dx[d];
			y+=dy[d];
			if(0<=x&&0<=y&&x<n&&y<n&&map[x][y]==eat) {
				return true;
			}
			
		}
		
		return false;
	}
}
