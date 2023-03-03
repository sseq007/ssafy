package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스타트와링크 {
	static int n,min_diff,team_n;
	static int[][] S;
	static boolean[] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		S = new int[n][n];
		team_n= n/2;
		v= new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				S[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,0);
	}
	private static void comb(int idx, int s) {

		if(idx ==team_n) {
			int team1=0;
			int team2=0;
			for (int i = 0; i < v.length; i++) {
				if(v[i]) {
					
				}
			}
			
			return;
		}
		
		for (int i = s; i < n; i++) {
			v[i]=true;
			comb(idx+1, i+1);
			v[i]=false;
		}
	}
}
