package ssafy.com.알고리즘.Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀과사다리게임 {
	static class Point{
		int start,end;

		public Point(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Point [start=" + start + ", end=" + end + "]";
		}
		
	}
	static int n,m;
	static Point[] ladder;
	static Point[] snake;
	static StringTokenizer st;
	static int min_cnt = Integer.MAX_VALUE;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = new  boolean[101];
		ladder= new Point[n];
		snake = new Point[m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			ladder[i]=new Point(start, end);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			snake[i]=new Point(start, end);
		}
		
		dfs(1,0);
		System.out.println(min_cnt);
	}
	private static void dfs(int x, int cnt) {
		//100번 칸 도착
		if(x>=100) {
			min_cnt=Math.min(min_cnt, cnt);
			return;
		}
		v[x]=true;
		//주사위 굴리기
		L: for (int d = 1; d <=6 ; d++) {
			int nx = x+d;
			if(0<=nx&&nx<=100&&!v[nx]) {
				//사다리 타기
				for (int i = 0; i < ladder.length; i++) {
					if(ladder[i].start==nx) {
						v[nx]=true;
						dfs(ladder[i].end, cnt+1);
						v[nx]=false;
						continue L;
					}
				}

				//뱀 타기
				for (int i = 0; i < ladder.length; i++) {
					if(ladder[i].start==nx) {
						v[nx]=true;
						dfs(ladder[i].end, cnt+1);
						v[nx]=false;
						continue L;
					}
				}
				//그냥 가기
				v[nx]=true;
				dfs(nx, cnt+1);
//				v[nx]=false;
			}
		}
	}
	private static boolean checkS(int nx, int cnt) {
		for (int i = 0; i < snake.length; i++) {
			if(snake[i].start==nx) {
				v[nx]=true;
				dfs(snake[i].end, cnt+1);
				v[nx]=false;
				return true;
			}
		}
		return false;
	}
	private static boolean checkL(int nx,int cnt) {
		
		for (int i = 0; i < ladder.length; i++) {
			if(ladder[i].start==nx) {
				v[nx]=true;
				
				dfs(ladder[i].end, cnt+1);
				v[nx]=false;
				return true;
			}
		}
		
		return false;
	}
}
