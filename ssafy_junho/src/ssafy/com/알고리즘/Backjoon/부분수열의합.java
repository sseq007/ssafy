package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분수열의합 {
	static int n,s,cnt;
	static boolean[] v;
	static int[] arr;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		v = new boolean[n];
		cnt=0;
		powerset(0);
		System.out.println(cnt);
	}
	private static void powerset(int idx) {
		if(idx==n) {
			if(AllFalse())return;
			int sum=0;
			for (int i = 0; i < v.length; i++) {
				if(v[i])sum+=arr[i];
			}
			if(sum==s)cnt++;
			return;
		}
		v[idx]=true;
		powerset(idx+1);
		v[idx]=false
				;
		powerset(idx+1);
	}
	private static boolean AllFalse() {
		for (int i = 0; i < v.length; i++) {
			if(v[i]) return false;
		}
		return true;
	}
}
