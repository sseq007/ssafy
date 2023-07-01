package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 베스트셀러 {

	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap< String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			if(!map.containsKey(input)) {
				map.put(input, 1);
			}else {
				map.put(input, map.get(input)+1);
			}
		}
		for (String key : map.keySet()) {
			int val = map.get(key);
			
			
		}
		
	}
}
