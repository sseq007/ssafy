package ssafy.com.알고리즘.a형막트.찐막;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사격게임 {

	static int n,sum,anw;
	static int[] nums;
	static boolean[] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			n = Integer.parseInt(br.readLine());
			nums = new int[n];
			v  = new boolean[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				nums[i]=Integer.parseInt(st.nextToken());
			}
			anw = 0;
			recur(0);
			System.out.println("#"+tc+" "+anw);
		}
	}
	private static void recur(int idx) {
		if(idx==n) {
			anw = Math.max(anw, sum);
			return;
		}
		for (int i = 0; i < n; i++) {
			if(!v[i]) {
				v[i]=true;
				int score= getScore(i);
				sum+=score;
				recur(idx+1);
				v[i]=false;
				sum-=score;
			}
		}
		
	}
	private static int getScore(int idx) {
		int left = idx-1;
		int right = idx+1;
		while(left>=0) {
			if(!v[left]) break;
			left --;
		}
		while(right<n) {
			if(!v[right]) break;
			right++;
		}
		if(left<0&&right<n) return nums[right];
		if(left>=0&&right>=n) return nums[left];
		if(left>=0&&right<n) return nums[left]*nums[right];
		
		return nums[idx];
	}
}
