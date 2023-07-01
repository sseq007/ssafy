package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 두수의합2 {

	static int n,x;
	static int[] arr;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		x= Integer.parseInt(br.readLine());
		int cnt=0;
		int left=0;
		int right=arr.length-1;
		int sum=0;
		Arrays.sort(arr);
		while(true) {
			if(left>=right) break;
			sum = arr[left]+arr[right]; 
			if(sum<=x) {
				left++;
			}else if(sum>x) {
				right--;
			}
			if(sum==x) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}
}
