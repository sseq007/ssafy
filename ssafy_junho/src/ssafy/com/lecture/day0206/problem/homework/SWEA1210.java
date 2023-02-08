package ssafy.com.lecture.day0206.problem.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[S/W 문제해결 기본] 2일차 - Ladder1
public class SWEA1210 {

	static int[][] board;
	static StringTokenizer st;
	static Point end;
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int T = Integer.parseInt(br.readLine());
			for(int i=0;i<100;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					board[i][j]=Integer.parseInt(st.nextToken());
					if(board[i][j]==2) end = new Point(i, j);
				}
			}
			
			for(int i=0;i<100;i++){
				for(int j=0;j<100;j++) {
					
				}
			
			}
		
			
			
		}
		

	}

}

class Point{
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
