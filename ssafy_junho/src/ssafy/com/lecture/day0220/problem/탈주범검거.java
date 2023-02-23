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
			int size = q.size();
			
			for(int k=0;k<size;k++) {
				Point p = q.poll();
				int num = map[p.x][p.y];
				for(int i=0;i<4;i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					if(check(nx,ny)) {
						int next = map[nx][ny];
						if(i==0) {
							if(num==1||num==2||num==5||num==6) {
								if(next==1||next==2||next==4||next==7) {
									v[nx][ny]=true;
									q.offer(new Point(nx, ny));
								}
							}
						}
						else if(i==1) {
							if(num==1||num==2||num==4||num==7) {
								if(next==1||next==2||next==5||next==6) {
									v[nx][ny]=true;
									q.offer(new Point(nx, ny));
								}
							}
						}
						else if(i==2) {
							if(num==1||num==3||num==4||num==5) {
								if(next==1||next==3||next==6||next==7) {
									v[nx][ny]=true;
									q.offer(new Point(nx, ny));
								}
							}
						}
						else if(i==3) {
							if(num==1||num==3||num==6||num==7) {
								if(next==1||next==3||next==4||next==5) {
									v[nx][ny]=true;
									q.offer(new Point(nx, ny));
								}
							}
						}
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
