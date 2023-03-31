package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이 {
	static class Point{
		int x,y,cnt,cnt2;

		public Point(int x, int y, int cnt, int cnt2) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.cnt2 = cnt2;
		}
		
		
	}
	static int[] dx= {-1,0,1,0,-2,-2,-1,1,2,2,1,-1}; //말일때
	static int[] dy= {0,-1,0,1,-1,1,2,2,1,-1,-2,-2};
	static int k,n,m;
	static int[][] map;
	static boolean[][][] v;
	static StringTokenizer st;
	static int anw=-1;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		v= new boolean[m][n][k+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		bfs(0, 0);
		System.out.println(anw);

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=========================");
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y, 0, 0));
		v[x][y][0] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == m - 1 && p.y == n - 1) {
				anw = p.cnt2;
				return;
			}
			// 말로 갈수 있는 경우
			if (p.cnt < k) {
				for (int d = 4; d < 12; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];
					if (0 > nx || 0 > ny || nx >= m || ny >= n)continue;
					if (!v[nx][ny][p.cnt+1] && map[nx][ny] == 0) {
						v[nx][ny][p.cnt+1] = true;
						q.add(new Point(nx, ny, p.cnt + 1, p.cnt2 + 1));
					}
				}
			} 
				// 원숭이로 가는 경우
				for (int d = 0; d < 4; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];
					if (0 > nx || 0 > ny || nx >= m || ny >= n)
						continue;
					if (!v[nx][ny][p.cnt] && map[nx][ny] == 0) {
						v[nx][ny][p.cnt] = true;
						q.add(new Point(nx, ny, p.cnt, p.cnt2+1));
					}
				}
			
		}

	}
	
}
