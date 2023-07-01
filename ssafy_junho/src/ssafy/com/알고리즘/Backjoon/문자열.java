package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String input1 = st.nextToken();
		String input2 = st.nextToken();
		
		int anw = input1.length();
		
		for (int i = 0; i < input2.length()-input1.length()+1; i++) {
			int min = 0;
			for (int j = 0; j < input1.length(); j++) {
				if(input1.charAt(j)!=input2.charAt(j+i)) {
					min++;
				}
			}
			anw= Math.min(anw, min);
		}
		System.out.println(anw);
	}
}
