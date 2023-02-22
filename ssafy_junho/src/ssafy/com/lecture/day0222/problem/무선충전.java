package ssafy.com.lecture.day0222.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
 * 
 * 
 * */
public class 무선충전 {
	static int[] dy= {0,-1,0,1,0};
	static int[] dx= {0,0,1,0,-1};
	static StringTokenizer st;
	static int m,a;
	static AP[] BC;
	static int[] moveA;
	static int[] moveB;
	static int total;
	static class Point{
		int y,x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static class AP{
		int y,x,c,p;
		public AP(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
		
	}
	
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			moveA = new int[m+1];
			moveB = new int[m+1];
			total=0;
			BC = new AP[a];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<m+1;i++) {
				moveA[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<m+1;i++) {
				moveB[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<a;i++) {
				st = new StringTokenizer(br.readLine());
				BC[i]=new AP(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			Point cur_a = new Point(1, 1);
			Point cur_b = new Point(10, 10);

			for (int second = 0; second < m + 1; second++) {
				int max=0;
				cur_a = new Point(cur_a.y + dy[moveA[second]], cur_a.x + dx[moveA[second]]);
				cur_b = new Point(cur_b.y + dy[moveB[second]], cur_b.x + dx[moveB[second]]);

				//a와 b가 충전기에 있을 모든 경우의 수
				for (int i = 0; i < BC.length; i++) {
					for (int j = 0; j < BC.length; j++) {
						int[] charge = new int[2];
						int sum=0;
						if (Math.abs(cur_a.y - BC[i].y) + Math.abs(cur_a.x - BC[i].x) <= BC[i].c) {
							charge[0] = BC[i].p;
						}
						if (Math.abs(cur_b.y - BC[j].y) + Math.abs(cur_b.x - BC[j].x) <= BC[j].c) {
							charge[1] = BC[j].p;
						}
						if(i!=j) { // 같은 충전기에 없을 경우
							sum=charge[0]+charge[1];
						}
						else { // 같은 충전기에 있을 경우
							sum=Math.max(charge[0], charge[1]);
						}
						

						max= Math.max(max, sum);
					}

				}
				total+=max;
			}
			System.out.println("#"+tc+" "+total);

		}
	}
}
