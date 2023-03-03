package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import ssafy.com.알고리즘.Backjoon.연구소.Point;

public class 연구소 {
	static class Point{
		int x,y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	static int[][] map;
	static int n,m,max_size;
	static ArrayList<Point> blank;
	static Point[] sel;
	static int[][] copyMap;
	static StringTokenizer st;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		max_size=Integer.MIN_VALUE;
		map= new int[n][m];
		copyMap= new int[n][m];
		blank = new ArrayList<Point>();
		sel = new Point[3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					blank.add(new Point(i, j));
				}
			}
		}
		recur(0,0);
		
		System.out.println(max_size);
	}
	private static void print() {
		for (int i = 0; i < copyMap.length; i++) {
			for (int j = 0; j < copyMap[i].length; j++) {
				System.out.print(copyMap[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static void recur(int idx, int s) {
		if(idx==3) {
//			System.out.println(Arrays.toString(sel));
			copy(copyMap);
			
			for (int i = 0; i < sel.length; i++) {
				copyMap[sel[i].x][sel[i].y]=1;
			}
//			print();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(copyMap[i][j]==2) {
						bfs(i,j);
						
					}
				}
			}
			int zero_cnt=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(copyMap[i][j]==0) zero_cnt++;
				}
			}
			max_size=Math.max(zero_cnt, max_size);
			return;
		}
		
		for (int i = s; i < blank.size(); i++) {
			sel[idx]=blank.get(i);
			
			recur(idx+1, i+1);
		}
	}
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x, y));
		copyMap[x][y]=3;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				if(0<=nx&&nx<n&&0<=ny&&ny<m&&copyMap[nx][ny]==0) {
					q.offer(new Point(nx, ny));
					copyMap[nx][ny]=3;
				}
			}
			
		}
		
	}
	private static void copy(int[][] copyMap2) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copyMap2[i][j]=map[i][j];
			}
		}
		
	}
	
}
