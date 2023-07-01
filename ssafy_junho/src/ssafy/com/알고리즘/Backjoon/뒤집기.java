package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		StringTokenizer st0 = new StringTokenizer(input,"0");
		StringTokenizer st1 = new StringTokenizer(input,"1");
		System.out.println(Math.min(st0.countTokens(), st1.countTokens()));
		
	}
}
