package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 타일링 {
	static	String n;
	static BigInteger[] dp;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp = new BigInteger[251];
		dp[1]=new BigInteger("1");
		dp[2]=new BigInteger("3");
		
		
		while(true) {
			n = br.readLine();
			if(n==null) {
				
				break;
			}
			for (int i = 3; i <=Integer.parseInt(n.toString()); i++) {
				dp[i]=dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
			}
			
			if(Integer.parseInt(n)==0) {
				System.out.println("1");
			}else {
				
				System.out.println(dp[Integer.parseInt(n.toString())]);
			}
			
			
		}
		
		
		
	}
	
}
