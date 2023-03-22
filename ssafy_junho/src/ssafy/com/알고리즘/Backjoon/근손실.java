package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 근손실 {
	static int n,k,cnt;
	static int[] kit;
	static boolean[] v;
	static int[] sel;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		kit = new int[n];
		sel = new int[n];
		v = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			kit[i]=Integer.parseInt(st.nextToken());
		}
		cnt=0;
		perm(0);
		System.out.println(cnt);
		
	}
	private static void perm(int idx) {
		if(idx==sel.length) {
//			System.out.println(Arrays.toString(sel));
			int init = 500;
			for (int i = 0; i < sel.length; i++) {
				init=init-k+kit[sel[i]];
				if(init<500) {
					return;
				}
			}
			cnt++;
			return;
		}
		for (int i = 0; i <n ; i++) {
			if(!v[i]) {
				v[i]=true;
				sel[idx]=i;
				perm(idx+1);
				v[i]=false;
			}
		}
	}
}
