package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
	static List<Integer>[][] list;
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
			list = new ArrayList[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					list[i][j]=new ArrayList<Integer>();
				}
			}
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
//					System.out.println(p.toString());
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
							list[nx][ny].add(i);
						}else {
							p.x=nx;
							p.y=ny;
							list[nx][ny].add(i);
						}
//						System.out.println("상"+p.toString());
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
							list[nx][ny].add(i);
						}else {
							p.x=nx;
							p.y=ny;
							list[nx][ny].add(i);
						}
//						System.out.println("하"+p.toString());
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
							list[nx][ny].add(i);

						}else {
							p.x=nx;
							p.y=ny;
							list[nx][ny].add(i);

						}
//						System.out.println("좌"+p.toString());
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
							list[nx][ny].add(i);

						}else {
							p.x=nx;
							p.y=ny;
							list[nx][ny].add(i);

						}
//						System.out.println("우"+p.toString());
					}
				}
				
				
				for (int a = 0; a < n; a++) {
					for (int b = 0; b < n; b++) {
						int sum=0;
						int max_val= Integer.MIN_VALUE;
						int max_idx=0;
						if(list[a][b].size()>=2) {
							for (int c = 0; c < list[a][b].size(); c++) {
								int num = list[a][b].get(c);
								sum+=data.get(num).cnt;
								if(max_val<data.get(num).cnt) {
									max_val = data.get(num).cnt;
									max_idx = num;
								}
							}
							
							for (int c = 0; c < list[a][b].size(); c++) {
								if(list[a][b].get(c)==max_idx) {
									data.get(list[a][b].get(c)).cnt = sum;
								}else {
									
									data.get(list[a][b].get(c)).cnt=0;
								}
							}
							
						}
					}
				}
//				print(list);
				clear(list);
				m--;
			}
			int anw=0;
//			System.out.println(data.toString());
			for (int i = 0; i < data.size(); i++) {
				if(data.get(i).cnt!=0) {
					anw+=data.get(i).cnt;
//					System.out.println(data.get(i).cnt);
					
				}
			}
			
			System.out.println("#"+tc+" "+anw);
			
			
		}
		
	}
	
	private static void clear(List<Integer>[][] list2) {
		for (int i = 0; i < list2.length; i++) {
			for (int j = 0; j < list2[i].length; j++) {
				list[i][j].clear();
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
	private static void print(List<Integer>[][] list2) {
		for (int i = 0; i < list2.length; i++) {
			for (int j = 0; j < list2[i].length; j++) {
				System.out.print(list2[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
