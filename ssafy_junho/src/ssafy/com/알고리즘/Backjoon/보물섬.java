package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 2589
public class 보물섬 {
	static class Point{
		int x,y,time;

		public Point(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		
		
	}
	static int n,m;
	static int max_time,max_x,max_y;
	static char[][] map;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st= new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j]=input.charAt(j);
			}
		}
		max_time=0;
		max_x=0;
		max_y=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]=='L') {
					bfs(i,j);
					
				}
			}
		}
//		System.out.printf("%d %d %d",max_time,max_x,max_y);
		System.out.println(max_time);
		
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[n][m];
		q.add(new Point(x, y,0));
		v[x][y]=true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(max_time<p.time) {
				max_time = p.time;
				max_x=p.x;
				max_y=p.y;
			}
			for (int d = 0; d < 4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				//범위를 벗어나는 경우
				if(0>nx||0>ny||nx>=n||ny>=m) continue;
				//방문 했으면
				if(v[nx][ny])continue;
				//다음이 육지이면
				if(map[nx][ny]=='L') {
					v[nx][ny]=true;
					
					q.add(new Point(nx, ny,p.time+1));
				}
			}
		}
		
		
	}
}
