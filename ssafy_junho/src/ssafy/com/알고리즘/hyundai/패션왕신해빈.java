package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 패션왕신해빈 {

	static int n ,cnt;
	static HashMap<String, Integer> map;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String val = st.nextToken();
				String key = st.nextToken();
				map.put(key, map.getOrDefault(key, 0)+1);
			}
//		    System.out.println(map.toString());
			cnt=1;
			for (String key : map.keySet()) {
				int val = map.get(key);
				cnt*=val+1;
			}
			System.out.println(cnt-1);
		}
	}

}
