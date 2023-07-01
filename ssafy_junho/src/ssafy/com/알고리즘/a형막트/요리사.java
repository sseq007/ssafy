package ssafy.com.알고리즘.a형막트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 요리사 {

	static int n,min_val;
	static int[][] map;
	static boolean[] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			v = new boolean[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			min_val=Integer.MAX_VALUE;
			comb(0,0);
			System.out.println("#"+tc+" "+min_val);
		}
	}
	private static void comb(int idx, int s) {
		if(idx==n/2) {
//			System.out.println(Arrays.toString(v));
			//a=>true b=>false
			int a=0;
			int b= 0;
			int total=0;
			for (int i = 0; i < v.length-1; i++) {
				for (int j = i+1; j <v.length; j++) {
					if(v[i]&&v[j]) {
						a+=(map[i][j]+map[j][i]);
					}else if(!v[i]&&!v[j]) {
						b+=(map[i][j]+map[j][i]);
						
					}
				}
			}
			total = Math.abs(a-b);
			
			min_val=Math.min(total, min_val);
			return;
		}
		
		for (int i = s; i < n; i++) {
			v[i]=true;
			comb(idx+1, i+1);
			v[i]=false;
		}
		
	}
}
