package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 4179
public class 불 {

	static class Point{
		int x,y,time;
		boolean isFire;
		public Point(int x, int y, int time, boolean isFire) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.isFire = isFire;
		}
		
	}
	static int n,m,min_time=Integer.MAX_VALUE;
	static char[][] map;
	static Queue<Point> q = new LinkedList<>();
	static Point person;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,-1,1};
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j]=input.charAt(j);
				if(map[i][j]=='J') {
					person = new Point(i, j, 1, false);
					if(isEdge(i,j)) {
						System.out.println(person.time);
						System.exit(0);
					}
				}else if (map[i][j]=='F') {
					q.add(new Point(i, j, 1, true));
					
				}
			}
		}
		
		bfs();
		System.out.println(min_time==Integer.MAX_VALUE?"IMPOSSIBLE":min_time);
	}
	private static void bfs() {
		boolean[][] v = new boolean[n][m];
		q.add(person);
		v[person.x][person.y]=true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(!p.isFire&&isEdge(p.x, p.y)) {
				min_time=Math.min(min_time, p.time);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				//범위가 벗어나면
				if(0>nx||0>ny||nx>=n||ny>=m) continue;
				//벽이거나 불이면
				if(map[nx][ny]=='#'||map[nx][ny]=='F') continue;
				
				//불일때
				if(p.isFire) {
					map[nx][ny]='F';
					q.add(new Point(nx, ny, p.time+1, p.isFire));
				}
				//사람일때
				else if(!p.isFire&&!v[nx][ny]) {
					v[nx][ny]=true;
					q.add(new Point(nx, ny, p.time+1, p.isFire));
				}
			}
		}
		
	}
	private static boolean isEdge(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dx[d];
			if(0>nx||0>ny||nx>=n||ny>=m) return true;
		}
		return false;
	}
}
