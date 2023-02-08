package ssafy.com.lecture.day0206.APS±âº»;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice {
//	static int arr[] = {10,20,30};
	static int n,m;
	static int[] arr;
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws Exception, IOException {	
//		print_array(0);
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[m];
		
		dfs(1,0);
		System.out.println(sb);
		
	}
	private static void dfs(int s,int depth) {
		
		if(depth==m) {
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]).append(" ");
			}sb.append("\n");
			
			return;
		}
		
		for(int i=s;i<=n;i++) {
			arr[depth]=i;
			dfs(i,depth+1);
		}
		
	}

//	private static void print_array(int idx) {
//		if(idx==arr.length) {
//			return;
//		}
//		
//		System.out.print(arr[idx]+"\t");
//		
//		print_array(idx+1);
//		
//	}
}
