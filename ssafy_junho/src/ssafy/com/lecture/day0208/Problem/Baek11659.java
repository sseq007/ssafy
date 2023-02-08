package ssafy.com.lecture.day0208.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구간 합 구하기4
public class Baek11659 {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] data= new int[n+1];
	
		st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=n;i++) {
			data[i]=data[i-1]+Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			sb.append((int)Math.abs(data[a-1]-data[b])).append("\n");
			
		}
		
		
		
		
		System.out.println(sb);
		
		
	}

	
}
