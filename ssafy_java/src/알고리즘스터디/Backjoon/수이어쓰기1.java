package 알고리즘스터디.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기1 {

	public static void main(String[] args) throws Exception, IOException {
		
		String data ="";
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=n;i++) {
			
			data+=Integer.toString(i);
		}
		System.out.println(data.length());
		

	}

}
