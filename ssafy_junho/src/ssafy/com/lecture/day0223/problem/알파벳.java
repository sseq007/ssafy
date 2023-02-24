package ssafy.com.lecture.day0223.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int r,c;
	static int cnt;
	static int[][] map;
	static boolean[] v;
	static StringTokenizer st;
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		cnt=0;
		map = new int[r][c];
		v = new boolean[26];
		for (int i = 0; i < r; i++) {
			String input = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j]=input.charAt(j)-'A';
			}
		}
		v[map[0][0]]=true;
		dfs(0,0,1);
		System.out.println(max);
		
	}
	private static void dfs(int x, int y,int cnt) {
		//최댓값 update
		if(max<cnt) {
			max = cnt;
		}
		
		for(int d=0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			//map 범위 안에 있고 알파벳이 안 겹칠 경우
			if(0<=nx&&nx<r&&0<=ny&&ny<c&&!v[map[nx][ny]]) {
					v[map[nx][ny]]=true;
					dfs(nx, ny,cnt+1);
					v[map[nx][ny]]=false;
					
			}
		}
	}
}
