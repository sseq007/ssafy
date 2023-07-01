package ssafy.com.알고리즘.hyundai;

import java.util.*;
import java.io.*;

public class 듣보잡 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String,Integer>map = new HashMap();
		for (int i = 0; i < n; i++) {
			String key = br.readLine();
			map.put(key, 0);
		}
		ArrayList<String> arr = new ArrayList();
		for (int i = 0; i < m; i++) {
			String key = br.readLine();
			if(map.containsKey(key)) {
				arr.add(key);
			}
		}
		Collections.sort(arr);
		System.out.println(arr.size());
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
