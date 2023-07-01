package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 서로다른부분문자열의개수 {

	static boolean[] v;
	static Map<String, Integer> map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr = br.readLine();
		map = new HashMap<>();
		int idx=1;
		for (int i = 0; i <arr.length(); i++) {
			for (int j = i+1; j <= arr.length(); j++) {
				map.put(arr.substring(i, j),0);
			}
		}
		System.out.println(map.size());
	}
	
}
