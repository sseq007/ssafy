package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//BOJ 16457
public class 단풍잎이야기 {

	static int n,m,k,max_sum=Integer.MIN_VALUE;
	static int[] sel;
	static int[][] skill;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new  StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		skill = new int[m][k];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				skill[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		sel= new int[n];
		recur(0,1);
		System.out.println(max_sum);
	}
	private static void recur(int idx, int s) {
		if(idx==sel.length) {
//			System.out.println(Arrays.toString(sel));
			int sum=0;
			for (int i = 0; i < m; i++) {
				int cnt=0;
				for (int j = 0; j < k; j++) {
					for (int t = 0; t < n; t++) {
						if(skill[i][j]==sel[t]) cnt++;
					}
				}
				if(cnt==k) sum++;
			}
			max_sum=Math.max(sum, max_sum);
			return;
		}
		//조합 뽑기
		for (int i = s; i <=2*n; i++) {
			sel[idx]=i;
			recur(idx+1, i+1);
		}
		
	}
}
