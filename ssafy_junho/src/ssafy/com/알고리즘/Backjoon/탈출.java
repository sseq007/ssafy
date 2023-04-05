package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 3055
public class 탈출 {
	static class Point{
		int x,y,time,state;

		public Point(int x, int y, int time, int state) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.state = state;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", time=" + time + ", state=" + state + "]";
		}


		
		
	}
	static int[] dx= {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n,m;
	static int min_time = Integer.MAX_VALUE;
	static char[][] map;
	static Queue<Point> q = new LinkedList<Point>();
	static boolean[][] v;
	static boolean[][] v2;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		v = new boolean[n][m];
		v2 = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j]=input.charAt(j);
				if(map[i][j]=='*') {
					q.add(new Point(i, j, 1,0));
					v[i][j]=true;
				}
				
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]=='S') {
					q.add(new Point(i, j, 1,1));
					v2[i][j]=true;
				}
				
			}
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
//			System.out.println(p.toString());
			for (int d = 0; d < 4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				if(0>nx||0>ny||nx>=n||ny>=m) continue;
				if(map[nx][ny]=='D'&&p.state==1) {
					min_time = Math.min(min_time, p.time);
					break;
				}
				if(map[nx][ny]=='X'||map[nx][ny]=='D') continue;
				if(map[nx][ny]=='.'&&p.state==0&&!v[nx][ny]) {
					v[nx][ny]=true;
					q.add(new Point(nx, ny, p.time+1,p.state));
				}
				if(map[nx][ny]=='.'&&p.state==1&&!v[nx][ny]&&!v2[nx][ny]) {
					v2[nx][ny]=true;
					q.add(new Point(nx, ny, p.time+1,p.state));
				}
			}
		}
		if(min_time==Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(min_time);
		}
		
	}
}

