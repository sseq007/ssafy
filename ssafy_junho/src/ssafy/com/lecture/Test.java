package ssafy.com.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import ssafy.com.lecture.Test.Point;

public class Test {
	static class Point{
		int x,y,val,dir;

		public Point(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", val=" + val + "]";
		}
		
	}
	static class Point2{
		int x,y,dir,cnt;

		public Point2(int x, int y, int dir,int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point2 [x=" + x + ", y=" + y + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
		
		
		
	}
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] map;
	static int[][] map2;
	static ArrayList<Point> apple;
	static int n,cnt,curx,cury,curDir;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			n= Integer.parseInt(br.readLine());
			map = new int[n][n];
			map2=new int[n][n];
			apple = new ArrayList<Point>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]>0)apple.add(new Point(i, j,map[i][j]));
				}
			}
			Collections.sort(apple,new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1.val, o2.val);
				}
			});
			for (int i = 1; i < n; i++) {
				map2[i-1][n-1]=1;
				map2[n-1][i]=2;
				map2[i][0]=3;
			}
			print(map2);
			curx = 0;
			cury = 0;
			curDir=0;
			cnt=0;
			
			for (int i = 0; i < apple.size(); i++) {
				
				bfs(curx,cury,apple.get(i));
			}
			System.out.println(cnt);
		}
	}


	private static void bfs(int x, int y,Point apple) {
		Queue<Point2> q = new LinkedList<Point2>();
		boolean[][] v = new boolean[n][n];
		q.add(new Point2(x, y,curDir,0));
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!q.isEmpty()) {
			Point2 p = q.poll();
//			System.out.println(p.toString());
			if(p.x==apple.x&&p.y==apple.y) {
				cnt+=p.cnt;
						
				System.out.println("cnt "+cnt);
				curx=p.x;
				cury=p.y;
				curDir=p.dir;
				return;
				
			}
			
			int nx = p.x+dx[p.dir];
			int ny = p.y+dy[p.dir];
			if(0>nx||0>ny||nx>=n||ny>=n) continue; 
			//방향 오른쪽 사과가 오른쪽에 있을경우
			if(check(nx,ny,apple,p)==0) {

				System.out.println("000000");
				q.add(new Point2(nx, ny,1,p.cnt+1));
			}
			//방향 아래 사과가 오른쪽에 있을경우
			else if(check(nx,ny,apple,p)==1) {
				System.out.println("1111111");
				q.add(new Point2(nx, ny,2,p.cnt+1));

			}
			//방향 오른쪽 사과가 왼쪽에 있을경우
			else if(check(nx,ny,apple,p)==2) {
				System.out.println("2222222");
				q.add(new Point2(nx, ny,3,p.cnt+3));

			}
			//방향 아래 사과가 왼쪽에 있을경우
			else if(check(nx,ny,apple,p)==3) {
				System.out.println("333333");
				q.add(new Point2(nx, ny,0,p.cnt+3));
				

			}
			//방향 위쪽 사과가 오른쪽에 있을경우
			else if(check(nx,ny,apple,p)==4) {
				
//				System.out.println("1111");
				q.add(new Point2(nx, ny,0,p.cnt+1));
				System.out.println("444444");

			}
			//방향 왼쪽 사과가 오른쪽에 있을경우
			else if(check(nx,ny,apple,p)==5) {
				System.out.println("5555555");
				q.add(new Point2(nx, ny,3,p.cnt+1));
			}
			//방향 위쪽 사과가 왼쪽에 있을경우
			else if(check(nx,ny,apple,p)==6) {
				System.out.println("666666");
				q.add(new Point2(nx, ny,3,p.cnt+3));
			}
			//방향 왼쪽 사과가 왼쪽에 있을경우
			else if(check(nx,ny,apple,p)==7) {
				System.out.println("77777");
				q.add(new Point2(nx, ny,1,p.cnt+3));
			}
			else {
				if(nx==n-1) {
					q.add(new Point2(p.x, p.y-1, 3, p.cnt+3));
					q.add(new Point2(nx, ny, map2[nx][ny], p.cnt+1));
					
				}
				else if(ny==0) {
					q.add(new Point2(p.x-1, p.y, 0, p.cnt+3));
				}
				else {
					q.add(new Point2(nx, ny, p.dir, p.cnt));
				}
//				else if(nx==0) {
//					q.add(new Point2(p.x, p.y, 3, p.cnt+3));
//				}
//				else if(ny==n-1) {
//					q.add(new Point2(nx, ny, 3, p.cnt+3));
//				}
			}
		}
		
	}


	private static int check(int x, int y,Point apple,Point2 curApple) {
		for (int i = 1; i < n; i++) {
			if(curApple.dir==0&&x+i==apple.x&&y==apple.y) return 0;
			else if(curApple.dir==1&&y-i==apple.y&&x==apple.x) return 1;
			
			else if(curApple.dir==0&&x-i==apple.x&&y==apple.y) return 2;
			else if(curApple.dir==1&&y+i==apple.y&&x==apple.x) return 3;
			
			else if(curApple.dir==3&&y+i==apple.y&&x==apple.x) return 4;
			else if(curApple.dir==2&&x-i==apple.x&&y==apple.y) return 5;
			
			else if(curApple.dir==3&&y-i==apple.y&&x==apple.x) return 6;
			else if(curApple.dir==2&&x+i==apple.x&&y==apple.y) return 7;
			
			
		}
		
		return -1;
	}



	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}
//	if(curApple.dir==0&&x<apple.x&&y<apple.y) return 0;
//	else if(curApple.dir==1&&y>apple.y&&x>apple.x) return 1;
//	
//	else if(curApple.dir==0&&x>apple.x&&y>apple.y) return 2;
//	else if(curApple.dir==1&&y<apple.y&&x<apple.x) return 3;
//	
//	else if(curApple.dir==3&&y<apple.y&&x<apple.x) return 4;
//	else if(curApple.dir==2&&x>apple.x&&y>apple.y) return 5;
//	
//	else if(curApple.dir==3&&y>apple.y&&x>apple.x) return 6;
//	else if(curApple.dir==2&&x<apple.x&&y<apple.y) return 7;
}

