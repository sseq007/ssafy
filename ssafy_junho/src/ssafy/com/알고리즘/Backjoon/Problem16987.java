package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem16987 {

	static int n;
	static int[]egg_stregth;
	static int[]egg_weight;
	static boolean[] egg_broken;
	static StringTokenizer st;
	static int cnt;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		egg_stregth = new int[n];
		egg_weight = new int[n];
		egg_broken = new boolean[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			egg_stregth[i]=Integer.parseInt(st.nextToken());
			egg_weight[i]=Integer.parseInt(st.nextToken());
		}
		
		recur(0);
		System.out.println(cnt);
		
	}
	private static void recur(int idx) {
		if(idx == n) {
			for(int i=0;i<n;i++) {
				if(egg_broken[i]) {
					cnt+=1;
				}
			}
//			System.out.println(Arrays.toString(egg_broken));
			return;
		}
		
		int start_es = egg_stregth[idx];
		int start_ew = egg_weight[idx];
		System.out.println("처음 계란 내구도"+start_es);
		System.out.println("처음 계란 무게"+start_ew);
		if (start_es <= 0 || allbroken()) {
			recur(idx + 1);
		} else {
			boolean[] egg_temp = Arrays.copyOf(egg_broken, n);
			for (int i = 0; i < n; i++) {
				if (i == idx) continue;
				if (egg_broken[i]) continue;
				start_es -= egg_weight[i]; // 왼쪽계란 치기
				egg_stregth[i] -= start_ew; // 오른쪽 계란 치기
				if (start_es <= 0) {
					egg_broken[idx] = true;
				}
				if (egg_stregth[i] <= 0) {
					egg_broken[i] = true;
				}
				System.out.println(Arrays.toString(egg_broken));
				recur(idx + 1);
				
				egg_broken = Arrays.copyOf(egg_temp, n);
				start_es += egg_weight[i]; // 왼쪽계란 치기
				egg_stregth[i] += start_ew; // 오른쪽 계란 치기

				

			}
		}
	}
	private static boolean allbroken() {
		for(int i=0;i<n;i++) {
			if(!egg_broken[i])
				return false;
		}
		return true;
	}
}
