package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ 1065
public class 메모장 {
	public static void main(String[] args) throws Exception {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		if(n<100) {
			cnt = n;
			System.out.println(cnt);
			System.exit(0);
		}else {
			cnt=99;
		}
		
		for (int i = 100; i <=n; i++) {
			String str = Integer.toString(i);
			if(str.charAt(1)-'0'-str.charAt(0)-'0'==str.charAt(2)-'0'-str.charAt(1)-'0') {
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}
}
