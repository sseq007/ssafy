package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N�� M(4)
public class Problem15652 {

	static int n,m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		
		
		dfs(1,0);
		
		System.out.println(sb);
		
		
		
	}
	
	private static void dfs(int s,int depth) {
		
		if(depth==m) {
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]).append(' ');
			}sb.append("\n");
			
			return;
		}
		
		for(int i=s;i<=n;i++) {
			arr[depth]=i;
			dfs(i,depth+1);
		}
		
	}
}
