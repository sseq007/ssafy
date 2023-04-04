package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//부분집합
public class 보호필름 {
	static int d,w,k;
	static int[][] copyMap;
	static int[][] map;
	static int[] v;
	static int min_val;
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
			min_val=Integer.MAX_VALUE;
			recur(0,0);
			System.out.println("#"+tc+" "+min_val);
		}
	}
	private static void recur(int idx,int cnt) {
		if(idx==v.length) {
//			System.out.println(Arrays.toString(v));
			
			if(check()) {
				min_val = Math.min(min_val, cnt);
			}
			
			return;
		}
		//선택안할떄
		v[idx]=0;
		recur(idx+1,cnt);
		//A 선택할떄
		v[idx]=1;
		recur(idx+1,cnt+1);
		//B 선택할떄
		v[idx]=2;
		recur(idx+1,cnt+1);
		
	}
	private static boolean check() {
		int cnt,a,b;
		for (int i = 0; i < w; i++) {
			cnt=1;
			for (int j = 0; j < d-1; j++) {
				a = map[j][i];
				b = map[j+1][i];
				if(v[j]>0) {
					a =v[j]-1;
				}
				if(v[j+1]>0) {
					b =v[j+1]-1;
				}
				if(a==b) {
					cnt++;
				}else {
					cnt=1;
					
				}
				if(cnt>=k) {
					break;
				}
			}
//			System.out.println(cnt);
			if(cnt<k) {
				return false;
				
			}
		}
		
		return true;
	}
//	private static void copyMap(int[][] map) {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				copyMap[i][j]=map[i][j];
//			}
//		}
//	}
}
