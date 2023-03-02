package ssafy.com.lecture.day0302.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import ssafy.com.lecture.day0302.problem.벽돌꺠기.Point;

public class 벽돌꺠기 {
	static class Point{
		int x,y,val;
		public Point(int x, int y,int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
		
	}
	static int[][] map;
	static int[] sel;
	static boolean[][] v;
	static int[][] copyMap;
	static StringTokenizer st;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int n,w,h,brick_n,min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			map = new int[h][w];
			sel = new int[n];
			copyMap = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					
				}
			}
			
			//중복순열
//			print(copyMap);
			recur(0);
			System.out.println("#"+tc+" "+min);
		}
	}
	private static void recur(int idx) {
		if(idx ==n) {
			System.out.println(Arrays.toString(sel));
			brick_n=0;
			for (int i = 0; i < h; i++) {
				System.arraycopy(map[i],0 , copyMap[i], 0, w);
			}
			
			for (int i = 0; i < sel.length; i++) {
				int index = sel[i];
				for (int j = 0; j < h; j++) {
					if(copyMap[j][index]!=0) {
						System.out.println(copyMap[j][index]);
						bfs(j,index);
						break;
					}
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(copyMap[i][j]!=0) {
						brick_n++;
					}
				}
			}
			min = Math.min(brick_n, min);
			print(copyMap);
			
			
			
			
			return;
		}
		for (int i = 0; i < w; i++) {
			sel[idx]=i;
			recur(idx+1);
		}
		
	}
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x, y,map[x][y]));
		copyMap[x][y]=0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 1; i < p.val; i++) {
				
				for(int d=0;d<4;d++) {
					int nx = p.x+dx[d]*i;
					int ny = p.y+dy[d]*i;
					if(0<=nx&&nx<h&&0<=ny&&ny<w&&copyMap[nx][ny]!=0) {
						copyMap[nx][ny]=0;
						q.offer(new Point(nx, ny,map[nx][ny]));
					}
				}
			}
		}
		
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
		
	}
}
