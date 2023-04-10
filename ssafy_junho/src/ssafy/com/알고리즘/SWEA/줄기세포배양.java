package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄기세포배양 {
	static class Point{
		int x,y,state,time;

		public Point(int x, int y, int state, int time) {
			super();
			this.x = x;
			this.y = y;
			this.state = state;
			this.time = time;
		}
		
	}
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int n,m,k,Time;
	static int[][] map;
	static Queue<Point> q;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map= new int[n][m];
			q = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					//1 비활성 2 활성 3 죽음
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]!=0) {
						q.add(new Point(i, j, 1, map[i][j]));
					}
				}
			}
			Time = 1;
			while(true) {
				
				while(!q.isEmpty()) {
					Point p = q.poll();
					//활성 상태일떄 확산
					if(p.state!=2) {
						if(p.state==1&&p.time==Time) {
							p.state=2;
							q.add(new Point(p.x, p.y, p.state, p.time));
						}
						
					}else {
						for (int d = 0; d < 4; d++) {
							int nx = p.x+dx[d];
							int ny = p.y+dy[d];
							if(0>nx||0>ny||nx<=n||ny<=n) {
								q.add(new Point(nx, ny, 1, p.time));
								continue;
							}
							//두 개 이상의 줄기 세포가 동시 먼식
						}
						
					}
					Time++;
				}
			}
			
		}
		
	}
	private static boolean checkState(Point p) {
		
		return false;
	}
	
}
