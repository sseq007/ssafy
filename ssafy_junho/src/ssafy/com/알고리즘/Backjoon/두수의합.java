package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 두수의합 {

	static int n,x;
	static int[] arr;
	static StringTokenizer st;
	static HashMap< Integer, Integer> map;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			map.put(arr[i], 0);
		}
		x= Integer.parseInt(br.readLine());
		int cnt=0;
		for (int i = 0; i < n; i++) {
			if(map.containsKey(x-arr[i])) {
				cnt++;
			}
		}
		System.out.println(cnt/2);
		
		
	}
}
