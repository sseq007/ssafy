package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선발명단 {
	
	static int[][] player;
	static int maxTotal;
	static StringTokenizer st;
	static boolean[] v;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			player= new int[11][11];
			v = new boolean[11];
			maxTotal=Integer.MIN_VALUE;
			for (int i = 0; i < 11; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 11; j++) {
					player[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			recur(0,0);
			System.out.println(maxTotal);
		}
		
	}
	private static void recur(int x, int total) {
		if(x==11) {
			maxTotal=Math.max(maxTotal, total);
			return;
		}
		
		
		for (int i = 0; i < 11; i++) {
			if(!v[i]&&player[x][i]!=0) {
				v[i]=true;
				recur(x+1, total+player[x][i]);
				v[i]=false;
			}
		}
		
	}
}
