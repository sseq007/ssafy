package ssafy.com.lecture.day0213.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ¾ÏÈ£¹®1 {
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<String> arr = new ArrayList<String>();
			ArrayList<String> code = new ArrayList<String>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr.add(st.nextToken());
			}
			int order_n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				code.add(st.nextToken());
			}
			
			for(int i=0;i<code.size();i++) {
				if(code.get(i).equals("I")) {
					int x = Integer.parseInt(code.get(i+1));
					int y = Integer.parseInt(code.get(i+2));
					
					for(int j=0;j<y;j++) {
						arr.add(x+j, code.get(i+3+j));;
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0;i<10;i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
		}
		
	}
}
