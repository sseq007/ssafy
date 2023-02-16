package ssafy.com.lecture.day0215.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정사각형방 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] map;
	static int n;
	static StringTokenizer st;
	static int room_cnt,max;
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			max=0;
			int room_idx=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					room_cnt=0;
					int count=dfs(i,j,1);
					if(max<count) {
						max=count;
						room_idx = map[i][j];
					}
					else if(count==max) {
						if(room_idx>map[i][j]) room_idx = map[i][j];
					}
				
				}
			}
			System.out.println("#"+tc+" "+room_idx+" "+max);
			
		}
		
	}
	private static int dfs(int x, int y,int cnt) {

		if(room_cnt<cnt) room_cnt=cnt;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(0<=nx&&nx<n&&0<=ny&&ny<n&&map[nx][ny]==map[x][y]+1) {
				
				dfs(nx, ny, cnt+1);
			}
		}
		
		return room_cnt;
		
	}
}
