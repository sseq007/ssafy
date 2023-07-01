package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자카드 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(Integer.parseInt(st.nextToken()), 0);
		}
		int m = Integer.parseInt(br.readLine());
		int[] result = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < result.length; i++) {
		int check = Integer.parseInt(st.nextToken());
		if(map.containsKey(check)) {
			result[i]=1;
		}else {
		result[i]=0;
		}
	}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}
}
