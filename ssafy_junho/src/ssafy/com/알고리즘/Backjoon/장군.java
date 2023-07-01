package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 16509
public class 장군 {

	static class Point{
		int x,y,cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	static int[][] map;
	static int input_x,input_y,king_x,king_y,min_cnt=Integer.MAX_VALUE;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][9];
		 st = new StringTokenizer(br.readLine());
		 input_x= Integer.parseInt(st.nextToken());
		 input_y= Integer.parseInt(st.nextToken());
		 st = new StringTokenizer(br.readLine());
		 king_x= Integer.parseInt(st.nextToken());
		 king_y= Integer.parseInt(st.nextToken());
		 
		 
		bfs(input_x,input_y);
		System.out.println(min_cnt==Integer.MAX_VALUE?-1:min_cnt);
	}
	static int[][][] dir= {
			{{-1,0},{-1,-1},{-1,-1}},
			{{-1,0},{-1,1},{-1,1}},
			{{1,0},{1,1},{1,1}},
			{{1,0},{1,-1},{1,-1}},
			{{0,-1},{1,-1},{1,-1}},
			{{0,-1},{-1,-1},{-1,-1}},
			{{0,1},{1,1},{1,1}},
			{{0,1},{-1,1},{-1,1}},
	};
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 0));
		boolean[][] v = new boolean[10][9];
		v[x][y]=true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x==king_x&&p.y==king_y) {
				min_cnt = Math.min(min_cnt, p.cnt);
				return;
			}
			
			for (int d = 0; d < 8; d++) {
				int nx = p.x;
				int ny = p.y;
				for (int i = 0; i < 3; i++) {
					nx+=dir[d][i][0];
					ny+=dir[d][i][1];
					//범위를 벗어나면
					if(0>nx||0>ny||nx>=10||ny>=9) break;
					//갔다 왔으면
					if(v[nx][ny]) break;
					//장애물이 있으면
					if(i!=2&&(nx==king_x&&ny==king_y)) break;
					
					if(i==2) {
//						v[nx][ny]=true;
						q.add(new Point(nx, ny, p.cnt+1));
					}
					
				}
				
			}
		}
	}
}
