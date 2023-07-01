package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B  = br.readLine();
		
		while(A.length()<B.length()) {
			StringBuilder sb = new  StringBuilder();
			if(B.endsWith("A")) {
				B = B.substring(0, B.length()-1);
			}else {
				B = B.substring(0, B.length()-1);
				B = sb.append(B).reverse().toString();
			}
		}
		System.out.println(A.equals(B)?1:0);
		
	}
}
