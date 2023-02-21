package ssafy.com.lecture.day0221.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen {

	static int n,cnt;
	static int[][] map;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		cnt=0;
		recur(0);
		System.out.println(cnt);
	}
	
	/*
	 * Queen : 1 blank : 0
	 * 
	 */
	private static void recur(int x) {
		// basis part
		if (x == n) {
			cnt++;
//			print(map);
		}
		print(map);
		// inductive part

		for (int y = 0; y < n; y++) {
			if (check(x,y)) {
				map[x][y] = 1;
				recur(x + 1);
				map[x][y] = 0;
			}

		}
	}
	//r,c 위치에 퀸을 놓는 시점에 검사해야 하는 방향은
	//상,상좌,상우
	//퀸이 있으면 false
	//없으면 true
	private static boolean check(int x, int y) {
		//상
		for(int i=x-1;i>=0;i--) {
			if(map[i][y]==1) return false;
		}
		//상좌
		for(int i=x-1,j=y-1; i>=0&&j>=0;i--,j--) {
			if(map[i][j]==1) return false;
			
		}
		//상우
		for(int i=x-1,j=y+1;i>=0&&j<n;i--,j++) {
			if(map[i][j]==1) return false;
		}
		
		
		return true;
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
