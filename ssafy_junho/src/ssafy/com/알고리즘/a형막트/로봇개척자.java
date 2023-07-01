package ssafy.com.알고리즘.a형막트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇개척자 {

	static class robot {
		int x, y, d, cnt;

		public robot(int x, int y, int d, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "robot [x=" + x + ", y=" + y + ", d=" + d + ", cnt=" + cnt + "]";
		}
		
	}

	static class Seed {
		int x, y, time,k;
		boolean endgrow;
		public Seed(int x, int y, int time, int k, boolean endgrow) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.k = k;
			this.endgrow = endgrow;
		}
		@Override
		public String toString() {
			return "Seed [x=" + x + ", y=" + y + ", time=" + time + ", k=" + k + ", endgrow=" + endgrow + "]";
		}
		
	}

	static int n, m,max_cnt;
	static Queue<robot> q;
	static int[][] map;
	static Seed[][] seed;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			seed = new Seed[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					seed[i][j] = new Seed(i, j, 0, 1,false);
				}
			}
			max_cnt=Integer.MIN_VALUE;
			// 로봇을 놓자
			//
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							putrobat(i, j, d);
						}
					}
				}
			}
			System.out.println(max_cnt); 
		}
	}

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	private static void putrobat(int x, int y, int d) {
		q = new LinkedList<>();
		q.add(new robot(x, y, d, 0));
		int day = 0;
		int cnt=0;
		while (true) {
			if (day == m) {
				max_cnt=Math.max(max_cnt, cnt);
				break;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					//씨를 심었다면
					if(seed[i][j].time!=0) {
						seed[i][j].time++;
					}
					//씨가 싹이 난다면
					if(seed[i][j].time==seed[i][j].k+5) {
						seed[i][j].endgrow=true;
					}
				}
			}
			robot p = q.poll();
			System.out.println(p.toString());
			
			boolean flag = false;
			if(seed[p.x][p.y].endgrow) {
					// 곡식이 열린 경우 수확을 하자
					cnt++;
					seed[p.x][p.y].endgrow=false;
					seed[p.x][p.y].time=0;
					seed[p.x][p.y].k=seed[p.x][p.y].k+1;
					flag = true;
			}
			print();
			// 오전
			// 현재 농지 빈농지 다음 농지 이동 할 수 있는 경우
			if (seed[p.x][p.y].time == 0 && canGo(p, q)) {
				// 이동 가능하면 씨를 심어
				if(!seed[p.x][p.y].endgrow&&!flag) {
					seed[p.x][p.y] = new Seed(p.x, p.y, 1, 1,false);
				}
				

			}
			else if(seed[p.x][p.y].time==0&&!canGo(p,q)) {
				q.add(new robot(p.x, p.y, p.d, p.cnt));
			}
			System.out.println(day);
			System.out.println("cnt"+cnt);
			day++;

		}

	}

	private static void print() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(seed[i][j].toString());
			}
			System.out.println();
		}
		System.out.println("########################");
	}

	private static boolean canGo(robot p, Queue<robot> q) {
		int cnt = 0;
		int nx;
		int ny;
		// 이동 가능 한 곳은 빈농지 또는 곡식이 열린 농지
		// 로봇 방향 왼쪽
		if (p.d == 0) {
			nx = p.x + dx[1];
			ny = p.y + dy[1];
			if (seed[nx][ny].time == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 1, p.cnt));
				return true;
			}
			nx = p.x + dx[0];
			ny = p.y + dy[0];
			if (seed[nx][ny].time  == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 0, p.cnt));
				return true;
			}
			
			nx = p.x + dx[3];
			ny = p.y + dy[3];
			if (seed[nx][ny].time  == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 3, p.cnt));
				return true;
			}
			
			nx = p.x + dx[2];
			ny = p.y + dy[2];
			if (seed[nx][ny].time  == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 2, p.cnt));
				return true;
			}
			

		}
		// 로봇이 위쪽인 경우
		else if (p.d == 1) {
			nx = p.x + dx[2];
			ny = p.y + dy[2];
			if (seed[nx][ny].time  == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 2, p.cnt));
				return true;
			}
			nx = p.x + dx[1];
			ny = p.y + dy[1];
			if (seed[nx][ny].time  == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 1, p.cnt));
				return true;
			}
			
			nx = p.x + dx[0];
			ny = p.y + dy[0];
			if (seed[nx][ny].time  == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 0, p.cnt));
				return true;
			}
			
			nx = p.x + dx[3];
			ny = p.y + dy[3];
			if (seed[nx][ny].time  == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 3, p.cnt));
				return true;
			}
			

		}
		// 로봇 방향 오른쪽
		if (p.d == 2) {
			nx = p.x + dx[3];
			ny = p.y + dy[3];
			if (seed[nx][ny].time == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 3, p.cnt));
				return true;
			}
			nx = p.x + dx[2];
			ny = p.y + dy[2];
			if (seed[nx][ny].time  == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 2, p.cnt));
				return true;
			}
			
			nx = p.x + dx[1];
			ny = p.y + dy[1];
			if (seed[nx][ny].time == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 1, p.cnt));
				return true;
			}
			
			nx = p.x + dx[0];
			ny = p.y + dy[0];
			if (seed[nx][ny].time == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 0, p.cnt));
				return true;
			}
			
		}
		// 로봇 방향 아래쪽
		if (p.d == 3) {
			nx = p.x + dx[0];
			ny = p.y + dy[0];
			if (seed[nx][ny].time  == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 0, p.cnt));
				return true;
			}
			nx = p.x + dx[3];
			ny = p.y + dy[3];
			if (seed[nx][ny].time  == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 3, p.cnt));
				return true;
			}
			
			nx = p.x + dx[2];
			ny = p.y + dy[2];
			if (seed[nx][ny].time  == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 2, p.cnt));
				return true;
			}
			
			nx = p.x + dx[1];
			ny = p.y + dy[1];
			if (seed[nx][ny].time  == 0 || seed[nx][ny].endgrow) {
				q.add(new robot(nx, ny, 1, p.cnt));
				return true;
			}
			

		}
		
		return false;
	}
}
