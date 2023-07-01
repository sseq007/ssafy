package ssafy.com.알고리즘.a형막트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사과먹기게임 {

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
			for (int i = 0; i <n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]>0) {
						max_apple=Math.max(max_apple, map[i][j]);
					}
				}
			}
			min_turn=Integer.MAX_VALUE;
			dfs(0,0,0,0,1);
			System.out.println("#"+tc+" "+min_turn);
		}
	}
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	private static void dfs(int x, int y, int dir, int cnt, int eat) {
		
		//사과를 다먹으면 종료
		if(max_apple==eat-1) {
			min_turn = Math.min(min_turn, cnt);
			return;
		}
		
		int nx = x+dx[dir];
		int ny = y+dy[dir];
		
		//가다가 꺽어서 사과가 있는가?
		//벽을 만나는가?
		if(check(x,y,dir,eat)||(0>nx||0>ny||nx>=n||ny>=n)) {
			dir = (dir+1)%4;
			dfs(x, y, dir, cnt+1, eat);
			return;
		}
		//그냥 가
		if(map[x][y]==eat) {
			dfs(x, y, dir, cnt, eat+1);
		}else {
			dfs(nx, ny, dir, cnt, eat);
			
		}
		
	}
	private static boolean check(int x, int y, int dir, int eat) {
		dir = (dir+1)%4;
		
		while(x>=0&&y>=0&&x<n&&y<n) {
			x+=dx[dir];
			y+=dy[dir];
			if(x>=0&&y>=0&&x<n&&y<n) {
				if(map[x][y]==eat) {
					return true;
				}
			}
		}
		
		
		return false;
	}
}
