package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		int left=0;
		int right=0;
		int sum = 0;
		int result=0;
		
		while(true) {
			
			//합이 m보다 같거나 큰경우
			if(sum>=m) {
				sum-=nums[left];
				left++;
			}else if(right==n) break;
			else if ( sum<m) {
				sum+=nums[right];
				right++;
			}
			if(sum==m) {
				result++;
			}
		}
		System.out.println(result);
		
	}
}
