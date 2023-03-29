package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팀프로젝트 {
	
	static int n,cnt;
	static int[] arr;
	static boolean[] v1;
	static boolean[] v2;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			v1 = new boolean[n+1];
			v2 = new boolean[n+1];
			cnt=0;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <=n; i++) {
				arr[i]= Integer.parseInt(st.nextToken()); 
			}
			
			for (int i = 1; i <=n; i++) {
				if(!v1[i]) {
					dfs(i);
				}
			}
			
			System.out.println(n-cnt);
			
		}
		
		
		
	}
	private static void dfs(int x) {
		
		if(v1[x]) {
			return;
		}
		if(v2[x]) {
			v1[x]=true;
			v2[arr[x]]=true;
			cnt++;
		}
		v2[x]=true;
		dfs(arr[x]);
		v1[x]=true;
		v2[x]=false;
		
	}
}
