package ssafy.com.lecture.day0222.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 오나의여신님 {
	static class Point{
		int x,y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static char[][] map;
	static int m,n,dest_x,dest_y,cnt;
	static boolean[][] v;
	static boolean[][] v2;
	static int min;
	static boolean flag;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map= new char[n][m];
			min = Integer.MAX_VALUE;
			v = new boolean[n][m];
			v2 = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				String str= br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j]=str.charAt(j);
				}
			}
			dest_x=0;
			dest_y=0;
			cnt=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j]=='D') {
						dest_x=i;
						dest_y=j;
					}
				}
			}
			
			flag=false;
			
			bfs();
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(map[i][j]+" ");
//					}
//				System.out.println();
//				}
			
			if(!flag) {
				
				System.out.println("#"+tc+" "+"GAME OVER");
			}
			else {
				System.out.println("#"+tc+" "+min);
			}
			
		}
		
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'S') {
					q.offer(new Point(i, j));
					v[i][j]=true;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '*') {
					q.offer(new Point(i, j));
					v2[i][j]=true;
				}
			}
		}
		
		while (!q.isEmpty()) {
			
			Point p = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx&&nx<n&&0<=ny&&ny<m&&!v[nx][ny]&&map[nx][ny]!='X'&&map[nx][ny]!='*'&&map[p.x][p.y]=='S') {
					cnt++;
					if(nx==dest_x&&ny==dest_y) {
						flag = true;
						min = Math.min(cnt, min);
						return;
					}
					v[nx][ny]=true;
					map[nx][ny]='S';
					q.offer(new Point(nx,ny));
				}
				else if(0<=nx&&nx<n&&0<=ny&&ny<m&&!v2[nx][ny]&&map[nx][ny]!='D'&&map[nx][ny]!='X'&&map[p.x][p.y]=='*') {
					v2[nx][ny]=true;
					map[nx][ny]='*';
					q.offer(new Point(nx,ny));
				}
				
			}
			
		}

	}
}
