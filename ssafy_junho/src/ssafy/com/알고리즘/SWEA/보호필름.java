package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//순열
public class 보호필름 {
	static int d,w,k;
	static int[][] map;
	static int[] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map= new int[d][w];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j <w ; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			v = new int[d];
			recur(0);
		}
	}
	private static void recur(int idx) {
		if(idx==v.length) {
//			System.out.println(Arrays.toString(v));
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					
				}
			}
			
			return;
		}
		
		v[idx]=0;
		recur(idx+1);
		v[idx]=1;
		recur(idx+1);
		v[idx]=2;
		recur(idx+1);
		
	}
}
