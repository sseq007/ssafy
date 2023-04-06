package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class 진우의민트초코우유2 {
	static int n,m,h,max_milk;
	static int start_x,start_y;
	static int[][] map;
	static boolean[][] v;
	static boolean[][] v2;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map= new int[n][n];
		v= new boolean[n][n];
		v2= new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					start_x=i;
					start_y=j;
				}
			}
		}
		v[start_x][start_y]=true;
		max_milk=Integer.MIN_VALUE;
		dfs(start_x,start_y,m,0);
		
		
	}
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	private static void dfs(int x, int y, int m, int milk_n) {
		//체력이 없어==0
		if(m==0) {
			return;
		}
		//이동
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0>nx||0>ny||nx>=n||ny>=n) continue;
			if(!v[nx][ny]) {
				//빈칸이면
				if(map[nx][ny]==0) {
					v[nx][ny]=true;
					dfs(nx, ny, m-1, milk_n);
					v[nx][ny]=false;
				}
				//우유를 먹으면
				if(map[nx][ny]==2) {
					v2[nx][ny]=true;
					if(cangoHome(nx,ny,m+h)) {
						dfs(nx, ny, m+h, milk_n+1);
					}else {
						
					}
					v2[nx][ny]=false;
				}
			}
			
		}
		
		//집에 다시 도착
		if(x==start_x&&y==start_y) {
			
			return;
		}
	}
	private static boolean cangoHome(int x, int y, int m) {
		if(m==0) {
			return false;
		}
		
		if(x==start_x&&y==start_y) {
			return true;
		}
		
		//집을 갈 수 있으면
		for (int d = 0; d < 4; d++) {
			int nx  =x+dx[d];
			int ny = y+dy[d];
			if(0>nx||0>ny||nx>=n||ny>=n) continue;
			if(!v[nx][ny]) {
				if(map[nx][ny]!=2) {
					v2[nx][ny]=true;
					cangoHome(nx, ny, m-1);
					v2[nx][ny]=true;
					
				}
			}
		}
		
		return false;
	}
}
