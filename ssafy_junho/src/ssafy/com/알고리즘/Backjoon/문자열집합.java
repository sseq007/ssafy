package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열집합 {
	static int n,m;
	static String[] input;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new String[n];
		for (int i = 0; i < n; i++) {
			input[i]=br.readLine();
		}
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			String compare = br.readLine();
			for (int j = 0; j < n; j++) {
				if(compare.equals(input[j])) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
