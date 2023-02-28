package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위굴리기 {

	//left 1 4 6 3
	//right1 3 6 4
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	
	static StringTokenizer st;
	static int n,m,x,y,k;
	static int[][] map;
	static int[] order;
	static int[] dice;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dice = new int[7];
		order = new int[k];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
//		print();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			order[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < order.length; i++) {
			
			
			play(order[i]);
		}

		
		
	}

	private static void play(int idx) {
		
		//동
		if(idx==1) {
			int next_bottom = dice[3];
			
		}
		
	}
	
}
