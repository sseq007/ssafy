package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class 미생물격리 {
	static class Point{
		int x,y,cnt,dir;

		public Point(int x, int y, int cnt, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + ", dir=" + dir + "]";
		}
		
		
	}
	//상 1 하 2 좌 3 우 4
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int n,m,k;
	static int[][] map;
	static ArrayList<Point> data;
	static HashSet<Integer> set;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			data = new ArrayList<Point>();
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				data.add(new Point(x, y, cnt, dir));
			}
			setMap(map);
//			print(map);
			while(m!=0) {
				
				for (int i = 0; i < k; i++) {
					Point p = data.get(i);
					if(p.cnt==0) {
						continue;
					}
					//상
					if(p.dir==1) {
						int nx = p.x+dx[0];
						int ny = p.y+dy[0];
						if(redcheck(nx,ny)) {
							p.x=nx;
							p.y=ny;
							p.cnt=p.cnt/2;
							p.dir=2;
						}else {
							p.x=nx;
							p.y=ny;
						}
						System.out.println("상"+p.toString());
					}
					//하
					else if(p.dir==2) {
						int nx = p.x+dx[1];
						int ny = p.y+dy[1];
						if(redcheck(nx,ny)) {
							p.x=nx;
							p.y=ny;
							p.cnt=p.cnt/2;
							p.dir=1;
						}else {
							p.x=nx;
							p.y=ny;
						}
						System.out.println("하"+p.toString());
					}
					//좌
					else if(p.dir==3) {
						int nx = p.x+dx[2];
						int ny = p.y+dy[2];
						if(redcheck(nx,ny)) {
							p.x=nx;
							p.y=ny;
							p.cnt=p.cnt/2;
							p.dir=4;
						}else {
							p.x=nx;
							p.y=ny;
						}
						System.out.println("좌"+p.toString());
					}
					//우
					else  {
						int nx = p.x+dx[3];
						int ny = p.y+dy[3];
						if(redcheck(nx,ny)) {
							p.x=nx;
							p.y=ny;
							p.cnt=p.cnt/2;
							p.dir=3;
						}else {
							p.x=nx;
							p.y=ny;
						}
						System.out.println("우"+p.toString());
					}
				}
				samecheck();
				if(!set.isEmpty()) {
					Iterator<Integer> list = set.iterator();
					System.out.println(set.toString());
					int max_cnt = Integer.MIN_VALUE;
					int sum=0;
					while(list.hasNext()) {
						int next = list.next();
						sum+=next;
						max_cnt=Math.max(max_cnt, next);
					}
					while(list.hasNext()) {
						int next = list.next();
						
						for (int j = 0; j < data.size(); j++) {
							if(data.get(j).cnt==next) {
								if(data.get(j).cnt==max_cnt) {
									
									data.get(j).cnt=sum;
								}else {
									
									data.get(j).cnt=0;
								}
							}
							
						}
					}
					
					
				}
				m--;
			}
			int anw=0;
			System.out.println(data.toString());
			for (int i = 0; i < n; i++) {
				if(data.get(i).cnt!=0) {
					anw+=data.get(i).cnt;
				}
			}
			System.out.println(anw);
			
			
		}
		
	}
	
	private static boolean arange(int nx, int ny) {
		
		return false;
	}

	private static void samecheck() {
		set = new HashSet<>();
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				int a = data.get(i).x;
				int b = data.get(i).y;
				int c = data.get(j).x;
				int d = data.get(j).y;
				if(a==c&&b==d) {
					set.add(data.get(i).cnt);
					set.add(data.get(j).cnt);
				}
			}
			
		}
		
		
	}

	private static boolean redcheck(int nx, int ny) {
		if(0>nx||nx>=n||0>ny||ny>=n) {
			return false;
		}
		if(map[nx][ny]==1) {
			return true;
		}
		
		return false;
	}
	private static void setMap(int[][] map) {
		for (int i = 0; i < n; i++) {
			map[0][i]=1;
			map[n-1][i]=1;
			map[i][0]=1;
			map[i][n-1]=1;
		}
		
	}
	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
