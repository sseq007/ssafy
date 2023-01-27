package 알고리즘스터디.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//퇴사
public class Problem14501 {

	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		int[] T = new int[16];
		int[] P = new int[16];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i]=Integer.parseInt(st.nextToken());
			P[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			
		}
		
	}
}
