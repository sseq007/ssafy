package 알고리즘스터디.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15651 {

	static StringBuilder sb= new StringBuilder();
	static int[] arr;
	 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr= new int[m];
		dfs(n,m,0);
		
		System.out.println(sb);

	}
	public static void dfs(int n, int m, int d) {
		
		if(d==m) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=n;i++) {
			arr[d]=i;
			dfs(n,m,d+1);
		}
	
	}
}
