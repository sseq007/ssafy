package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n곱하기2타일링 {
	static int n;
	static long[] dp;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new long[1001];
		dp[1]=1;
		dp[2]=2;
		for (int i = 3; i <=n; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		System.out.println(dp[n]%10007);
		
	}
}
