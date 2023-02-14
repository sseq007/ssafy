package ssafy.com.lecture.day0214;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS05 {
	static int[][] map;
	/*
	 * 1 의 값이 사방으로 퍼지는데 걸리는 level을 구하세요
	 */
	static int N = 6;
	static int M = 6;
	static int level = 0;
	static int result;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("bfs05.txt"));

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		result=0;
		bfs();
		
		System.out.println(result);
	}

	private static void bfs() {
		Queue<Point> Q = new LinkedList();
		boolean[][] v = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) {
					v[i][j] = true;
					Q.offer(new Point(i, j,1));
				}
			}
		}
		

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			map[p.r][p.c] = 0;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				// 지도안에 있다면
				if (nr >= 0 && nr < N && nc >= 0 && nc < M &&!v[nr][nc]&& map[nr][nc] == 0) {
					v[nr][nc] = true;
					Q.add(new Point(nr, nc,p.level+1));
					result = Math.max(result, p.level);
				}
			}
		}
		
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static class Point {
		int r, c,level;

		public Point(int r, int c,int level) {
			super();
			this.r = r;
			this.c = c;
			this.level = level;
		}
	}
	
}
