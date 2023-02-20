package ssafy.com.lecture.day0220.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {
	//하,상,우,좌
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n,m,r,c,l;
	static int[][] map;
	static boolean[][] v;
	static StringTokenizer st;
	static int cnt;
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=  Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n= Integer.parseInt(st.nextToken());
			m= Integer.parseInt(st.nextToken());
			r= Integer.parseInt(st.nextToken());
			c= Integer.parseInt(st.nextToken());
			l= Integer.parseInt(st.nextToken());
			map= new int[n][m];
			v = new boolean[n][m];
			cnt=1;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			bfs(r,c);
			int result=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(v[i][j]) result++;
				}
			}
			System.out.println("#"+tc+" "+result);
			
		}
	}
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		v[x][y]=true;
		q.offer(new Point(x, y));

		while (!q.isEmpty()) {
			if (cnt == l) {
				
				return;
			}
			while(q.size()!=0) {
				
			}
			Point p = q.poll();
			if (map[p.x][p.y] == 1) {
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (check(nx, ny)) {
						v[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
			}
			else if (map[p.x][p.y] == 2) {
				for (int i = 0; i <2 ; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (check(nx, ny)) {
						v[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
			}
			else if (map[p.x][p.y] == 3) {
				for (int i = 2; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (check(nx, ny)) {
						v[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
			}
			else if (map[p.x][p.y] == 4) {
				for (int i = 1; i < 3; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (check(nx, ny)) {
						v[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
			}
			else if (map[p.x][p.y] == 5) {
				for (int i = 0; i < 4; i+=2) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (check(nx, ny)) {
						v[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
			}
			else if (map[p.x][p.y] == 5) {
				for (int i = 0; i < 4; i+=2) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (check(nx, ny)) {
						v[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
				
			}
			else if (map[p.x][p.y] == 6) {
				for (int i = 0; i < 4; i+=3) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (check(nx, ny)) {
						v[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
				
			}
			else if (map[p.x][p.y] == 7) {
				for (int i = 1; i < 4; i+=2) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (check(nx, ny)) {
						v[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
				
			}
			
		cnt++;
	}
	}

	private static boolean check(int nx, int ny) {
		if (0 <= nx && nx < n && 0 <= ny && ny < m && !v[nx][ny]&&map[nx][ny]!=0) {
			return true;
		}
		return false;
	}

}

class Point{
	int x,y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
