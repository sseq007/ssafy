package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의합 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int sum=0;
		for (int i = 0; i < n; i++) {
			sum+=input.charAt(i)-'0';
		}
		System.out.println(sum);
		
	}
}
