package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//BOJ 1941
public class 소문난칠공주 {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}
	static char[][] map;
	static Point[] sel;
	static boolean[][] v;
	static int[] dx= {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int anw;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		v = new boolean[5][5];
		sel = new Point[7];
		for (int i = 0; i < 5; i++) {
			String input = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j]=input.charAt(j);
			}
		}
		recur(0,0);
		System.out.println(anw);
	}

	private static void recur(int idx, int s) {
		if(idx==7) {
//			System.out.println(Arrays.toString(sel));
			if(isNear()) {
				anw++;
			}
			return;
		}
		
		for (int i = s; i < 25; i++) {
			int x = i/5;
			int y = i%5;
			sel[idx]= new Point(x, y);
			recur(idx+1, i+1);
		}
		
	}

private static boolean isNear() {
	Queue<Point> q = new LinkedList<>();
	v = new boolean[5][5];
	Point p = sel[0];
	int start_x = p.x;
	int start_y = p.y;
	int sCnt=0;
	int length=1;
	if(map[start_x][start_y]=='S') sCnt++;
	
	q.add(new Point(start_x, start_y));
	v[start_x][start_y]=true;
	while(!q.isEmpty()) {
		Point now = q.poll();
		for (int d = 0; d < 4; d++) {
			int nx = now.x+dx[d];
			int ny = now.y+dy[d];
			if(0>nx||0>ny||nx>=5|| ny>=5) continue;
			if(v[nx][ny]) continue;
			for (int i = 1; i < sel.length; i++) {
				Point next = sel[i];
				if(nx==next.x&&ny==next.y) {
					if(map[nx][ny]=='S') {
						sCnt++;
					}
					v[nx][ny]=true;
					length++;
					q.add(new Point(nx, ny));
				}
			}
		}
	}
	if(sCnt>=4&&length==7) {
		return true;
	}
	
		return false;
	}

//	private static void dfs(int x, int y,int cnt) {
//		if(cnt==7) {
//			int sum=0;
//			for (int i = 0; i < 5; i++) {
//				for (int j = 0; j < 5; j++) {
//					if(scount[i][j]==1) {
//						sum++;
//					}
//				}
//			}
//			if(sum<4) return;
//			
//			print(scount);
//			return;
//		}
//		
//		for (int d = 0; d < 4; d++) {
//			int nx = x+dx[d];
//			int ny = y+dy[d];
//
//			if(0>nx||0>ny||nx>=5|| ny>=5) continue;
//			if(v[nx][ny]) continue;
//			if(map[nx][ny]=='S') {
//				v[nx][ny]=true;
//				scount[nx][ny]=1;
//				dfs(nx, ny, cnt+1);
//				v[nx][ny]=false;
//				scount[nx][ny]=0;
//			}else {
//				v[nx][ny]=true;
//				dfs(nx, ny, cnt+1);
//				v[nx][ny]=false;
//			}
//		}
//	}
	private static void print(int[][] scount) {
		for (int i = 0; i < scount.length; i++) {
			for (int j = 0; j < scount[i].length; j++) {
				System.out.print(scount[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("=================");
	}
}
//for (int i = 0; i < 5; i++) {
//for (int j = 0; j < 5; j++) {
//	if(map[i][j]=='S') {
//		scount[i][j]=1;
//		v[i][j]=true;
//		dfs(i,j,1);
//		scount[i][j]=0;
//		v[i][j]=false;
//	}else {
//		v[i][j]=true;
//		dfs(i,j,1);
//		v[i][j]=false;
//	}
//	
//}
//}