package 알고리즘스터디.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//리모콘(미완료)
public class Problem1107 {

	// 0~9버튼 +,- 버튼
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String n = br.readLine();
		int m = Integer.parseInt(br.readLine());
		String[] data = br.readLine().split(" ");
		String check_broken ="";
		
		for (int i = 0; i < data.length; i++) {
			check_broken+=data[i];
		}
		
		if(n.equals("100")) {
			sb.append(0);
		}
		else {
			for(int i=0;i<n.length();i++) {
				String check_i=Character.toString(n.charAt(i));
				if(check_broken.contains(check_i)) {
					
				}
				
		}
		
		
	
	}
	}
}
