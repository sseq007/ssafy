package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위굴리기 {

	//left 1 4 6 3
	//right1 3 6 4
	static StringTokenizer st;
	static int n,m,x,y,k;
	static int[][] map;
	static int[] order;
	static int[][] dice;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		order = new int[k];
		dice = new int[7][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			order[i]=Integer.parseInt(st.nextToken());
		}
		
		setting_dice();
		

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					play(i,j);
				}
			}
		}
		
	}
	private static void play(int x,int y) {
		for(int i =0;i<order.length;i++) {
			if(order[i]==1) {
				int ny = y+1;
				if(ny>=m) continue;
				
				
			}
		}
	}
	private static void setting_dice() {
		
		for(int i=1;i<=6;i++) {
			dice[i][0]=i;
			dice[i][1]=7-i;
		}
		
		
		
	}
}
