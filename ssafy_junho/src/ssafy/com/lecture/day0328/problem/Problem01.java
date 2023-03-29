package ssafy.com.lecture.day0328.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem01 {
	static int n;
	static int[] dp;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//f(n)=2n-1
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		dp[1]=2;
		
		for (int i = 2; i <= n; i++) {
			dp[i]=(2*i)-1;
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
		
	}
}
