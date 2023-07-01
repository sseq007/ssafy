package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {

	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left=0;
		int right=arr.length-1;
		int sum=0;
		int result=Integer.MAX_VALUE;
		int idx1=0,idx2=0;
		while(true) {
			if(left>=right) break;
			
			sum = arr[left]+arr[right];
			if(Math.abs(sum)<result) {
				result = Math.abs(sum);
				idx1=left;
				idx2=right;
			}
			if(sum>=0) {
				right--;
			}else {
				left++;
			}
		}
		System.out.println(arr[idx1]+" "+arr[idx2]);
	}
}
