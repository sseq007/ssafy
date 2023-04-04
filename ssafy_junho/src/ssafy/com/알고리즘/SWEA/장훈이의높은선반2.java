package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 장훈이의높은선반2 {
	static int n,b;
	static int[] height;
	static boolean[] v;
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
			v = new boolean[n];
			recur(0);
			System.out.println("#"+tc+" "+min_height);
		}
		
	}
	private static void recur(int idx) {
		
		if(idx==n) {
//			System.out.println(Arrays.toString(v));
			int sum=0;
			for (int i = 0; i < v.length; i++) {
				if(v[i]) {
					sum+=height[i];
				}
			}
//			System.out.println(sum);
			if(sum<b) return;
			min_height=Math.min(min_height, sum-b);
			return;
		}
		v[idx]=true;
		recur(idx+1);
		v[idx]=false;
		recur(idx+1);
	}
}
