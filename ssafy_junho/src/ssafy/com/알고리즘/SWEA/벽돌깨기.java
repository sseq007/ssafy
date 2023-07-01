package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import ssafy.com.알고리즘.SWEA.벽돌깨기.Point;

public class 벽돌깨기 {

	static class Point{
		int x,y,val;
		public Point(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	static int n,w,h,min;
	static int[][] map;
	static Stack<Integer> stack;
	static int[] sel;
	static int[][] copyMap;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h= Integer.parseInt(st.nextToken());
			map = new int[h][w];
			sel = new int[n];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			//중복 순열 구하기
			recur(0);
			
			System.out.println("#"+tc+" "+min);
		}
	}
	private static void recur(int idx) {
		if(idx==n) {
//			System.out.println(Arrays.toString(sel));
			//벽돌 깨기
			copyMap = new int[h][w];
			copyMap();
//			print(copyMap);
			for (int i = 0; i < sel.length; i++) {
				
				for (int j = 0; j < h; j++) {
					if(copyMap[j][sel[i]]!=0) {
						bfs(j,sel[i]);
						down();
						break;
					}
				}
				
				
			}
			int brick_cnt=0;
			//벽돌 세기
			for (int i = 0; i < copyMap.length; i++) {
				for (int j = 0; j < copyMap[i].length; j++) {
					if(copyMap[i][j]!=0) brick_cnt++;
				}
			}
			min= Math.min(min, brick_cnt);
			
			return;
		}
		
		
		for (int i = 0; i < w; i++) {
			sel[idx]=i;
			recur(idx+1);
		}
	}
	private static void print(int[][] copyMap2) {
		for (int i = 0; i < copyMap2.length; i++) {
			for (int j = 0; j < copyMap2[i].length; j++) {
				System.out.print(copyMap2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}
	private static void down() {

		for (int i = 0; i < w; i++) {
			stack = new Stack<Integer>();
			int n = 0;
			for (int j = 0; j < h; j++) {
				if(copyMap[j][i]!=0) {
					stack.push(copyMap[j][i]);
					n++;
				}
			}
			for (int j = h-1; j > h-1-n; j--) {
				copyMap[j][i]=stack.pop();
			}
			for(int j=h-1-n;j>=0;j--) {
				copyMap[j][i]=0;
			}
		}
	}
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		boolean[][] v = new boolean[h][w];
		q.add(new Point(x, y, copyMap[x][y]));
		v[x][y]=true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int size = p.val;
			copyMap[p.x][p.y]=0;
			for (int i = 1; i < size; i++) {
				for (int d = 0; d < 4; d++) {
					int nx = p.x+(dx[d]*i);
					int ny = p.y+(dy[d]*i);
					//범위가 벗어나면
					if(0<=nx&&nx<h&&0<=ny&&ny<w&&!v[nx][ny]&&copyMap[nx][ny]!=0) {
						v[nx][ny]=true;
						q.add(new Point(nx, ny, copyMap[nx][ny]));
						copyMap[nx][ny]=0;
					}
				}
			}
		}
		
	}
	private static void copyMap() {
		for (int i = 0; i < copyMap.length; i++) {
			for (int j = 0; j < copyMap[i].length; j++) {
				copyMap[i][j]=map[i][j];
			}
		}
		
	}
}
