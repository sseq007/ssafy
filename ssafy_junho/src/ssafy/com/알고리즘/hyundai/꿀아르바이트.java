package ssafy.com.알고리즘.hyundai;
import java.util.*;
import java.io.*;
public class 꿀아르바이트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		long sum=0;
		long result=0;
		for (int i = 0; i < m; i++) {
			sum+=arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			if(i>=m) {
				sum-=arr[i-m];
			}
			sum+=arr[i];
			if(result<sum) {
				result=sum;
			}
		}
		System.out.println(result);
	}
	
	
}
