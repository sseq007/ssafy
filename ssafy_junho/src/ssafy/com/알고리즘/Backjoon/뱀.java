package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

import ssafy.com.알고리즘.Backjoon.뱀.Point;

/*
 * L : 반시계방향(-1)
 * D : 시계방향 (1)
 * 
 * 벽 또는 자기자신의 몸과 부딪히면 게임 끝
 * */
public class 뱀 {
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int n,k,l,second,count;
	static int[][] map;
	static boolean flag;
	static StringTokenizer st;
	static Deque<Point> deque;
	static class Point{
		int x,y,dir;
		public Point(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}
		
		
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map= new int[n][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a-1][b-1]=1;
		}
		l = Integer.parseInt(br.readLine());
		deque = new LinkedList<Point>();
		deque.add(new Point(0, 0, 1));
		second=0;
		count=0;
		for (int i = 0; i < l; i++) {
			st= new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			
			flag=false;
			move(X,C);
			if(flag) break;
			
		}
		
		System.out.println(second+1);
		
	}
	//뱀 이동
	private static void move(int x, char c) {
		
		
		while(true) {
			
			Point head = deque.peekFirst();	
			System.out.println(second);
			if(head.dir==1) {
				int nx = head.x+dx[0];
				int ny = head.y+dy[0];
				if(!check(nx,ny)) {
					second++;
				}
				
				else{
					flag = true;
					return;
				
				}
				
			}
			else if(head.dir==2) {
				int nx = head.x+dx[1];
				int ny = head.y+dy[1];
				if(!check(nx,ny)) {
					second++;
				}
				else{
					flag = true;
					return;
				
				}
			}
			else if(head.dir==3) {
				int nx = head.x+dx[2];
				int ny = head.y+dy[2];
				if(!check(nx,ny)) {
					second++;
				}
				else{
					flag = true;
					return;
				
				}
			}
			else if(head.dir==4) {
				int nx = head.x+dx[3];
				int ny = head.y+dy[3];
				if(!check(nx,ny)) {
					second++;
				}
				else{
					flag = true;
					return;
				
				}
			}
			if(second==x) {
				System.out.println("끝");
				count++;
				if(count==l) { 
					turn_head(c);
					continue;
				}
				break;
			}
			
		}
		turn_head(c);
		
		
	}
	private static void turn_head(char c) {
		Point head = deque.peekFirst();
		//뱀 머리 방향 바꾸기
		if(c=='L') {
			int next_dir=head.dir-1;
			head.dir=next_dir==0?4:next_dir;
//			System.out.println(head);
		}else {
			int next_dir=head.dir+1;
			head.dir=next_dir==5?1:next_dir;		
		}
		
	}
	private static boolean check(int nx, int ny) {
		//벽에 부딪히면
		if(0>nx||n<=nx||0>ny||n<=ny) return true;
		
		//규칙 시행
		if(map[nx][ny]==1) {
			map[nx][ny]=-1;
			deque.addFirst(new Point(nx, ny, deque.peekFirst().dir));
		}else {
			map[nx][ny]=-1;
			deque.addFirst(new Point(nx, ny, deque.peekFirst().dir));
			Point pl = deque.pollLast();
			map[pl.x][pl.y]=0;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		//자기 몸과 부딪히면
		Point head = deque.pollFirst();
		System.out.println("Head "+head);
		Iterator<Point> iter = deque.iterator();
		while(iter.hasNext()) {
			Point next = iter.next();
			System.out.println("next : "+next);
			if(head.x==next.x&&head.y==next.y) return true;
		}
		deque.addFirst(head);
		return false;
	}
}
