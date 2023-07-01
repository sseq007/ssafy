package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을것인가먹힐것인가 {

	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			int[] b = new int[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				b[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			Arrays.sort(b);
			
			int idx=0;
			int result=0;
			for (int i = 0; i < n; i++) {
				while(idx<m&&a[i]>b[idx]) {
					idx++;
				}
				result+=idx;
				
			}
			
			System.out.println(result);
		} 
	}
}
