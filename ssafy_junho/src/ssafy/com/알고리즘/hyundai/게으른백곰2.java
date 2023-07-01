package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//BOJ 10025
public class 게으른백곰2 {

	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[10001];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[x]=g;
		}
		
		int sum=0;
		int result=0;
		int d = (2*k)+1;
		
		for (int i = 0; i <= 100000; i++) {
			if(i>=d) {
				sum-=arr[i-d];
			}
			sum+=arr[i];
			
		}
	}
}
