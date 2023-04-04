package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의높은선반 {
	static int n,b;
	static int[] height;
	static int min_height;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			height = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				height[i]=Integer.parseInt(st.nextToken());
			}
			min_height=Integer.MAX_VALUE;
			recur(0, 0);
			System.out.println("#"+tc+" "+min_height);
		}
		
	}
	private static void recur(int idx, int sum) {
		
		if(idx==n) {
//			System.out.println(sum);
			if(sum<b) {
				return;
			}
			min_height= Math.min(min_height, sum-b);
			return;
		}
		
		recur(idx+1, sum);
		recur(idx+1, sum+height[idx]);
		
	}
}
