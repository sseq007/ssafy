package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린골호 {

	static int result=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		
		while(st.hasMoreTokens()) {
			int add=0;
			StringTokenizer st2 = new StringTokenizer(st.nextToken(),"+");
			
			while(st2.hasMoreTokens()) {
				add+=Integer.parseInt(st2.nextToken());
			}
			
			result=result==Integer.MAX_VALUE?result=add:result-add;
			
		}
		System.out.println(result);
	}
}
