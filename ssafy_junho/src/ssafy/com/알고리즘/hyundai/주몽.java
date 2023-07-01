package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽 {

	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr.length-1;
		int sum=0;
		int result=0;
		
		while(true) {
			if(left>=right) break;
			sum= arr[left]+arr[right];
			if(sum<=m) left++;
			else if(sum>m) right--;
			
			if(sum==m) result++;
			
		}
		
		System.out.println(result);
	}
}
