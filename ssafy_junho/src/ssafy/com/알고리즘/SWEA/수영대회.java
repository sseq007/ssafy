package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import ssafy.com.알고리즘.SWEA.수영대회결승전.Point;

public class 수영대회 {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int n,a,b,c,d,anw;
	static int[][] map;
	static boolean[][] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			n = Integer.parseInt(br.readLine());
			map= new int[n][n];
			v= new boolean[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			anw = Integer.MAX_VALUE;
			v[a][b]=true;
			dfs(a,b,0);
			
			System.out.print("#"+tc+" ");
			System.out.println(anw==Integer.MAX_VALUE?-1:anw);
		}
	}
	private static void dfs(int x, int y,int time) {
		if(x==c&&y==d) {
			anw = Math.min(time, anw);
			return;
		}
//		System.out.printf("%d %d %d\n",x,y,time);
		
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0>nx||0>ny||nx>=n||ny>=n) continue;
			if(v[nx][ny]) continue;
			if(map[nx][ny]==1) continue;
			v[nx][ny]=true;
			dfs(nx, ny,time+1);
			v[nx][ny]=false;
			
			
		}
		
	}
}
