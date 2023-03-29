package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 계단오르기 {
	static int n;
	static int[] stair;
	static int[] dp;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		stair = new int[300];
		dp = new int[10000];
		for (int i = 0; i < n; i++) {
			stair[i]=Integer.parseInt(br.readLine());
		}
		
		dp[0]=stair[0];
		dp[1]=Math.max(stair[1],stair[0]+stair[1]);
		dp[2]=Math.max(stair[0]+stair[2], stair[1]+stair[2]);
		for (int i = 3; i <n; i++) {
			dp[i]=Math.max(dp[i-3]+stair[i-1], dp[i-2])+stair[i];
		}
		
		
		
		
		
		System.out.println(dp[n-1]);
	}
}
