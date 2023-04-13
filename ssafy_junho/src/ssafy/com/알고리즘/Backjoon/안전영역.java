package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 2468
public class 안전영역 {

	static int n,cnt,result=1;
	static int start_height = Integer.MAX_VALUE;
	static int end_height = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				start_height=Math.min(start_height, map[i][j]);
				end_height = Math.max(end_height, map[i][j]);
			}
		}
		
		while(start_height<=end_height) {
			v= new boolean[n][n];
			//잠기는 구역 구하기
			findsink();
			
			//안전한 구역 구하기
			cnt=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(!v[i][j]) {
						
						dfs(i,j);
						cnt++;
					}
				}
			}
			result= Math.max(cnt, result);
			start_height++;
			
		}
		System.out.println(result);
		
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	private static void dfs(int x, int y) {
		
		v[x][y]=true;
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			//범위를 벗어나면
			if(0>nx||0>ny||nx>=n||ny>=n) continue;
			//방문했으면
			if(v[nx][ny]) continue;
			dfs(nx, ny);
		}
		
	}
	private static void findsink() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]<=start_height) {
					v[i][j]=true;
				}
			}
		}
		
	}
}
