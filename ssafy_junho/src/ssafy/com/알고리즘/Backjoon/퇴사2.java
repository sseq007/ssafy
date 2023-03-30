package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사2 {
	static int n;
	static long anw = Long.MIN_VALUE;
	static StringTokenizer st;
	static int[] T;
	static int[] P;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		T = new int[n+1];
		P = new int[n+1];
		for (int i = 1; i <=n; i++) {
			st = new StringTokenizer(br.readLine());
			T[i]=Integer.parseInt(st.nextToken());
			P[i]=Integer.parseInt(st.nextToken());
		}
		
		solve();
		
//		System.out.println(anw);
	}
	private static void solve() {

		int[] dp = new int[n+2];
		
		for (int day = 1; day <=n; day++) {
			int nday = day+T[day];
			if(nday<=n+1) {
				//현재일을 하는 경우와 아닌 경우중 큰값을 저장
				dp[nday]= Math.max(dp[day]+P[day], dp[nday]);
			}
			dp[day+1]=Math.max(dp[day], dp[day+1]);
		}
		System.out.println(dp[n+1]);
	}
	
}
