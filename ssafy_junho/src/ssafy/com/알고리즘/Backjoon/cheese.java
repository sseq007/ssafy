package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 2636
public class cheese {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int n,m,firstsum;
	static int[][] map;
	static StringTokenizer st;
	static ArrayList<Integer> cnt;
	static boolean[][] deleteV;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map= new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					firstsum++;
				}
			}
		}
		cnt = new ArrayList<Integer>();
		int Time=0;
		//치즈가 다 삭제될따까지 반복
		while(!allGone()) {
			deleteV = new boolean[n][m];
			v = new boolean[n][m];
			//치즈에 테투리 있는 영역 구하기
			outArea(0, 0);
			//치즈 삭제
			deleteCheese();
			//치즈 계수 저장
//			print(map);
			inputcheesecnt();
			Time++;
		}
		if(cnt.size()==1) {
			System.out.println(cnt.size());
			System.out.println(firstsum);
		}else {
			System.out.println(cnt.size());
			System.out.println(cnt.get(cnt.size()-2));
		}
	}
	private static void inputcheesecnt() {
		int sum=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==1) {
					sum++;
				}
			}
		}
		cnt.add(sum);
		
	}
	private static void deleteCheese() {
		for (int i = 0; i < deleteV.length; i++) {
			for (int j = 0; j < deleteV[i].length; j++) {
				if(deleteV[i][j]) {
					map[i][j]=0;
				}
			}
		}
		
		
	}
	private static void outArea(int x,int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		v[x][y] = true;
		deleteV[x][y] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (0 > nx || 0 > ny || nx >= n || ny >= m) continue;
				if(v[nx][ny]) continue;
				if (map[nx][ny] == 0) {
					v[nx][ny] = true;
					q.add(new Point(nx, ny));
				} else if (map[nx][ny] == 1) {
					deleteV[nx][ny] = true;
				}
			}
		}

	}
	private static boolean allGone() {
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j]!=0) {
					return false;
				}
					
			}
		}
		
		return true;
	}
	private static void print(int[][] inArea2) {
		for (int i = 0; i < inArea2.length; i++) {
			for (int j = 0; j < inArea2[i].length; j++) {
				System.out.print(inArea2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("======================");
	}
}
