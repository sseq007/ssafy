package ssafy.com.lecture.day0224.problem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//적록색약

/*
 * 빨강:R
 * 초록:G
 * 파랑:B
 * 
 * */
public class 적록색약 {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] v;
	static boolean[][] v2;
	static char[][] map;
	static char[][] map2;
	static int n,cnt1,cnt2;
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		map = new char[n][n];
		map2 = new char[n][n];
		v = new boolean[n][n];
		v2 = new boolean[n][n];
		cnt1=0;
		cnt2=0;
		for(int i=0;i<n;i++) {
			String str= br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j]=str.charAt(j);
				map2[i][j]=str.charAt(j);
				if(str.charAt(j)=='G') {
					map2[i][j]='R';
				}
			}
		}
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(map2[i][j]);
//			}
//			System.out.println();
//		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!v[i][j]) {
					bfs(i,j);
					cnt1++;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!v2[i][j]) {
					bfs2(i,j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1+" "+cnt2);
	}

	private static void bfs2(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		v2[x][y]=true;
		q.offer(new Point(x, y));

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !v2[nx][ny] && map2[nx][ny] == map2[p.x][p.y]) {
					v2[nx][ny] = true;
					q.offer(new Point(nx, ny));
				}
			}

		}
	}

	private static void bfs(int x, int y) {

		Queue<Point> q = new LinkedList<Point>();
		v[x][y]=true;
		q.offer(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n&&!v[nx][ny]&&map[nx][ny]==map[p.x][p.y]) {
						v[nx][ny]=true;
						q.offer(new Point(nx, ny));
				}
			}
				
		}
	}
}

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}