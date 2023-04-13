package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 14719
public class 빗물 {
	static int n,m;
	static int[] height;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		height = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			height[i]=Integer.parseInt(st.nextToken());
		}
		int idx = 0;
		
		while(idx<=m-1) {
			
			int startheight = height[idx];
			//처음 높이와 다음 높이의 차이는 작아야한다
		}
		
	}
}
