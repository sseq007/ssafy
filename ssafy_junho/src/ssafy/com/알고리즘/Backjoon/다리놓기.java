package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {
	
	static int[] dp;
	static int n,m;
	static long anw;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			n= Integer.parseInt(st.nextToken());
			m= Integer.parseInt(st.nextToken());
			//mCn
			anw = 1;
			for (int i = 0; i < n; i++) {
				anw=anw*(m-i)/(i+1);
			}
			
			System.out.println(anw);
			
		}
	}
}
