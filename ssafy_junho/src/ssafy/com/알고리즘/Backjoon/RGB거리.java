package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB거리 {
	static int n;
	static StringTokenizer st;
	static int[][] dp;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dp= new int[n+1][3];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dp[i][0]=Math.min(dp[i-1][1], dp[i-1][2])+r;
			dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2])+g;
			dp[i][2]=Math.min(dp[i-1][0], dp[i-1][1])+b;
		}
		
		
		
		int anw = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
		System.out.println(anw);
		
		
	}
}
