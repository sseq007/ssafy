package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());;
		}
		int[] count=new int[100001];
		int start=0;
		int end=0;
		int result=0;
		while(end<arr.length) {
			while(end<arr.length&&count[arr[end]]+1<=k) {
				count[arr[end]]++;
				end++;
			}
			int size = end-start;
			result = Math.max(result, size);
			count[arr[start]]--;
			start++;
		}
		System.out.println(result);
	}
	
}
