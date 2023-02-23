package ssafy.com.lecture.day0223.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import ssafy.com.lecture.day0223.problem.벽부수고이동하기.Point;

public class 벽부수고이동하기 {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] map;
	static int n,m;
	static boolean[][] v;
	static boolean[][] broke;
	static StringTokenizer st;

	static class Point {
		int x, y,cnt;
		boolean wall;
		public Point(int x, int y, int cnt, boolean wall) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.wall = wall;
		}

		

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
		broke = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String data = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = data.charAt(j) - '0';
			}
		}

		System.out.println(bfs(0,0));

	}

	private static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		v[x][y] = true;
		
		q.offer(new Point(x, y,1, false));
		while (!q.isEmpty()) {
			Point p = q.poll();
			if(p.x==n-1&&p.y==m-1) {
				return p.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (0 > nx || n <= nx || 0 > ny || m <= ny)
					continue;
				if (map[nx][ny] == 1) {
					if(!p.wall) {
						v[nx][ny]=true;
						broke[nx][ny]=true;
						q.offer(new Point(nx, ny, p.cnt+1, true));
						
					}
				}else if (map[nx][ny]==0) {
					if(!p.wall&&!v[nx][ny]&&!broke[nx][ny]) {
						v[nx][ny]=true;
						q.offer(new Point(nx, ny, p.cnt+1, false));
					}
					else if(p.wall&&!v[nx][ny]&&!broke[nx][ny]) {
						v[nx][ny]=true;
						q.offer(new Point(nx, ny, p.cnt+1, true));
					}
				}
			}
		}
		return -1;
	}
}
