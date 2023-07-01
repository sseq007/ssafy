package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 수정렬하기2 {
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr= new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr);
		for (int i = 0; i < n; i++) {
			sb.append(arr.get(i)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
