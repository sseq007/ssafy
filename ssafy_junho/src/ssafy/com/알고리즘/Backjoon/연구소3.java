package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소3 {
	static class Point{
		int x,y,cnt;
		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
		
	}
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int n,m,virus_n,min;
	static int[][] map;
	static StringTokenizer st;
	static ArrayList<Point> virus;
	static boolean[] v;
	static Queue<Point> q;
	static boolean[][] v2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		virus= new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					virus.add(new Point(i, j));
					virus_n++;
				}
			}
		}
		v= new boolean[virus_n];
		min = Integer.MAX_VALUE;
		comb(0,0);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
		
	}
	private static void comb(int idx, int s) {
		if(idx==m) {
//			System.out.println(Arrays.toString(v));
			q= new LinkedList<>();
			v2 =new  boolean[n][n];
			for (int i = 0; i < v.length; i++) {
				if(v[i]) {
					q.add(new Point(virus.get(i).x, virus.get(i).y, 0));
					v2[virus.get(i).x][virus.get(i).y]=true;
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]==1) v2[i][j]=true;
				}
			}
			bfs();
			
			return;
		}
		
		for (int i = s; i < virus.size(); i++) {
			v[i]=true;
			comb(idx+1, i+1);
			v[i]=false;
		}
	}
	private static void bfs() {
		
		while(!q.isEmpty()) {
				Point p = q.poll();
//				System.out.println(p);
				
				for (int d = 0; d < 4; d++) {
					int nx = p.x+dx[d];
					int ny = p.y+dy[d];
					if(0>nx||0>ny||nx>=n||ny>=n) continue;
					if(v2[nx][ny]) continue;
					if(map[nx][ny]==0 ||map[nx][ny]==2) {
						v2[nx][ny]=true;
						if(check()) {
							min=Math.min(min, p.cnt+1);
//							System.out.println(p.cnt);
							return;
						}
						if(map[nx][ny]==0) {
							
							q.add(new Point(nx, ny, p.cnt+1));
						}else {
							
							q.add(new Point(nx, ny, p.cnt+1));
						}
					}
					
					
				}
		}
		
	}
	private static void print(boolean[][] v2) {
		for (int i = 0; i < v2.length; i++) {
			for (int j = 0; j < v2[i].length; j++) {
				System.out.print(v2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}
	private static boolean check() {
		int sum=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!v2[i][j]) sum++; 
			}
		}
		if(sum==0) return true; 
		
		return false;
	}
}
