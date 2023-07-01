package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 수찾기 {

	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] result = new int[m];
		for (int i = 0; i < m; i++) {
			int search = Integer.parseInt(st.nextToken());
			int left = 0;
			int right=n-1;
			boolean flag =false;
			while(left<=right) {
				int midIdx = (left+right)/2;
				int mid = arr[midIdx];
				if(mid<search) left=midIdx+1;
				else if(mid>search) right= midIdx-1;
				else {
					flag = true;
					break;
				}
			}
			if(flag) {
				result[i]=1;
			}else result[i]=0;
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
