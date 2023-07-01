package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 14248
public class 점프점프 {
	static int n,s,cnt;
	static int[] arr;
	static boolean[] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		v = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		s = Integer.parseInt(br.readLine());
//		v[s]=true;
		cnt=0;
		dfs(s);
		System.out.println(cnt);
	}
	private static void dfs(int idx) {
		
		
		if(idx<1||idx>=n+1) {
			return;
		}
		if(v[idx])return;
		v[idx]=true;
		cnt++;
		int next_left = idx+arr[idx];
		int next_right = idx-arr[idx];
		dfs(next_left);
		dfs(next_right);
		
	}
}
