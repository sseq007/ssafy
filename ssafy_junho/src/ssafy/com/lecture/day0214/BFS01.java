package ssafy.com.lecture.day0214;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 				1
 *			2		3
 * 		  4  5     6  7
 * */
public class BFS01 {
	static int[] dr = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner("1 2 3\n 4 5 6 \n 7 8 9\n");
		
		map = new int[3][3];
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		bfs(0);
	}
	private static void bfs(int idx) {
		//1. Queue�� �����
		//2. Queue�� �������� �ְ�
		//3. Queue�� �������� �ݺ��ϴµ�
		//4. �ϳ��� poll�ϰ� ���� ���� ���� �ִ� ��带 Queue�� �ִ´�.
		
		Queue<Point> q = new LinkedList<Point>();
		//�湮�迭
		boolean[][] v = new boolean[3][3];
		v[0][0]=true;
		q.offer(new Point(0, 0, map[0][0]));
		int level=0;
		while(!q.isEmpty()) {
			int size= q.size();
			Point p = q.poll();
			System.out.println(p.toString());
			System.out.println(level);
			for(int i=0;i<4;i++) {
				int nr = p.r+dr[i];
				int nc = p.c+dy[i];
				//������ �ִٸ�
				if(nr>=0&&nr<3&&nc>=0&&nc<3&&!v[nr][nc]) {
					v[nr][nc]=true;
					q.add(new Point(nr, nc, map[nr][nc]));
				}
			}
				
		}
		level++;
	}
}
class Point{
	int r,c,data;

	public Point(int r, int c, int data) {
		super();
		this.r = r;
		this.c = c;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Point [r=" + r + ", c=" + c + ", data=" + data + "]";
	}
	
	
}
