package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//BOJ 17144
public class 미세먼지안녕 {
	static class Point{
		int x,y,val;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		};
		
		
	}
	static int n,m,t;
	static ArrayList<Point> robot;
	static ArrayList<Point> dust;
	static int[][] map;
	static List<Point>[][] list;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		robot = new ArrayList();
		dust = new ArrayList();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					robot.add(new Point(i, j));
				}
				if(map[i][j]!=-1&&map[i][j]!=0) {
					dust.add(new Point(i, j, map[i][j]));
				}
			}
		}
		int Time = 0;
		while(++Time<=t) {
			//미세먼지 확산하기
			spreadDust();
			
		}
		
	}
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,-0,1,-1};
	private static void spreadDust() {
		for (int i = 0; i < dust.size(); i++) {
			int dirCnt=0;
			for (int d = 0; d < 4; d++) {
				int nx = dust.get(i).x+dx[d];
				int ny = dust.get(i).y+dy[d];
				//범위를 벗어나면
				if(0>nx||0>ny||nx>=n||ny>=m) continue;
				//로봇을 만나면
				if(map[nx][ny]==-1) continue;
				//확산할 수 있는 방향 수 세기
				dirCnt++;
			}
			//확산할 수 없으면
			if(dirCnt==0) continue;
			//확산 되는 양은 나누기 5
			int spreadVal = map[dust.get(i).x][dust.get(i).y];
		}
		
	}
}
