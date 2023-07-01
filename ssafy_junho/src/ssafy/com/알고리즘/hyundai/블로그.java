package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 21921
public class 블로그 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] day = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < day.length; i++) {
			day[i]=Integer.parseInt(st.nextToken());
		}
		int sum=0;
		int result=0;
		int cnt=0;
		for (int i = 0; i < n; i++) {
		
			if(i>=x) {
				sum-=day[i-x];
			}
			sum+=day[i];
			if(result<sum) {
				result=sum;
				cnt=1;
			}else if(result==sum) cnt++;
			
			
		}
		
		if(result==0) {
			System.out.println("SAD");
		}else {
			System.out.println(result);
			System.out.println(cnt);
		}
	}
}
