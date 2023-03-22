package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//7490번
public class 영만들기 {
	static int n;
	static ArrayList<Character> arr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			recur(1,1,1,0,"1");
			System.out.println(sb.toString());
		}
		
	}
	private static void recur(int idx, int cur, int sign, int sum, String str) {
		if(idx==n) {
			sum+=(cur*sign);
			if(sum==0) {
				sb.append(str).append("\n");
			}
			return;
		}
		//" "
		recur(idx+1, (cur*10)+(idx+1), sign, sum, str+" "+Integer.toString(idx+1));
		//+
		recur(idx+1, idx+1, 1, sum+(sign*cur), str+'+'+Integer.toString(idx+1));
		//-
		recur(idx+1, idx+1, -1, sum+(sign*cur), str+'-'+Integer.toString(idx+1));		
		
		
	}
	
}
