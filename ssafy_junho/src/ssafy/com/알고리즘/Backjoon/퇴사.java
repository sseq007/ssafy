package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
	static int n,anw=Integer.MIN_VALUE;
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
		
		//완 탐 (인자 -> 날짜,금액)
		recur(1,0);
		System.out.println(anw);
	}
	private static void recur(int day, int pay) {
		if(day==n+1) {
			anw = Math.max(anw, pay);
			return;
		}
		
		//일을 하는경우
		if(day+T[day]<=n+1) {
			
			recur(day+T[day], pay+P[day]);
		}
		//일을 하지 않는경우
		recur(day+1, pay);
		
	}
}
