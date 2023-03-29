package ssafy.com.lecture.day0328.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem02 {

	static int n;
	static int[] dp;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		//1cm 파랑
		//1cm 노란 
		//2cm 빨강
		dp = new int[n+1];
		dp[1]=2;
		
		for (int i = 2; i <= n; i++) {
			//i가 짝수일때
			if(i%2==0) {
				dp[i]=2*dp[i-1]+1;
			}
			//i가 홀수일떄
			else if(i%2==1) {
				dp[i]=3*(dp[i-1])+1;
			}
			
		}
		System.out.println(dp[n]);
		
		
		
		
		
	}
	
}
