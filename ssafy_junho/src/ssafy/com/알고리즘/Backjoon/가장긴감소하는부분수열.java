package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴감소하는부분수열 {
	static int n,cnt;
	static int max_cnt = Integer.MIN_VALUE;
	static int[] nums;
	static int[] dp;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n+1];
		dp = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <=n; i++) {
			nums[i]=Integer.parseInt(st.nextToken());
			dp[i]=1;
		}
		
		for (int i = 1; i <n; i++) {
			for (int j = i+1; j <=n; j++) {
				if(nums[i]>nums[j]) {
					dp[j]=Math.max(dp[i]+1, dp[j]);
				}
			}
					
		}
		System.out.println(Arrays.toString(dp));
	}
}
