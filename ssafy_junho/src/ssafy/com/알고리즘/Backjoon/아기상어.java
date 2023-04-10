package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int n;
	static int[][] map;
	static int[][] dist;
	static int curx,cury,cursize;
	static int cnt,minx,miny,mindist;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					curx=i;
					cury=j;
					map[i][j]=0;
				}
			}
		}
		cursize=2;
		cnt=0;
		while(true) {
			dist = new int[n][n];
			minx = Integer.MAX_VALUE;
			miny = Integer.MAX_VALUE;
			mindist = Integer.MAX_VALUE;
			bfs();
			
			
		}
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(curx, cury));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				//범위를 벗어나면
				if(0>nx||0>ny||nx>=n||ny>-n) continue;
				//상어보다 물고기 사이즈가 크다면
				if(map[nx][ny]>cursize||dist[nx][ny]!=0) continue;
				dist[nx][ny]=dist[p.x][p.y]+1;
				if(map[nx][ny]<cursize&&map[nx][ny]!=0) {
					if(mindist>dist[nx][ny]) {
						mindist = dist[nx][ny];
						minx = nx;
						miny = ny;
					}else if(mindist==dist[nx][ny]) {
						if(minx>nx) {
							minx = nx;
							miny = ny;
						}else if(minx==nx) {
							if(miny>ny) {
								minx=nx;
								miny = ny;
								
							}
						}
					}
				}
			}
		}
	}
}

