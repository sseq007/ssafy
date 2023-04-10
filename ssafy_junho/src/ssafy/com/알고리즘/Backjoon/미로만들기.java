package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 미로만들기 {
	static class Point implements Comparable<Point> {
		int x, y, count;

		public Point(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.count, o.count);
		}

	}
	static int n,anw=Integer.MAX_VALUE;
	static int[][] map;
	static int[][] cnt;
	static int remove_n;
	static boolean[][] v;
	static ArrayList<Point> blackroom;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		cnt = new int[n][n];
		blackroom = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j]=input.charAt(j)-'0';
				
			}
		}
		for (int i = 0; i < n; i++) {
				Arrays.fill(cnt[i], Integer.MAX_VALUE);
		}
		
		bfs();
		System.out.println(cnt[n-1][n-1]);
		
	}
	
	
	private static void bfs() {
		PriorityQueue<Point> q = new PriorityQueue<>();
		v = new boolean[n][n];
//		cnt[0][0] = 0;
		q.add(new Point(0, 0, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(v[p.x][p.y]) continue;
			v[p.x][p.y]= true; 
			
			for (int d = 0; d < 4; d++) {
				int nx  = p.x+dx[d];
				int ny  = p.y+dy[d];
				if(0>nx||0>ny||nx>=n||ny>=n) continue;
				
				
				if(map[nx][ny]==0) {
					if(p.count+1<cnt[nx][ny]) {
						cnt[nx][ny]= p.count+1;
						q.add(new Point(nx, ny, cnt[nx][ny]));
					}
				}else {
					if(p.count<cnt[nx][ny]) {
						cnt[nx][ny]=p.count;
						q.add(new Point(nx, ny,cnt[nx][ny]));
					}
				}
			}
		}
		
	}


	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
}
