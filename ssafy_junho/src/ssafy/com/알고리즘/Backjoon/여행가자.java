package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 여행가자 {

	static int n,m;
	static int[] parent;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int [n+1];
		for (int i = 1; i <=n; i++) {
			parent[i]=i;
		}
		for (int i = 1; i <=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <=n; j++) {
				if(Integer.parseInt(st.nextToken())!=0) {
					union(i,j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		
		int start = find(Integer.parseInt(st.nextToken()));
		int compare = 0;
		String anw = "YES";
		while(st.hasMoreTokens()) {
			int next = Integer.parseInt(st.nextToken());
			compare = find(next);
			if(start!=compare) {
				anw = "NO";
				break;
			}
			start = compare;
			
		}
//		System.out.println(Arrays.toString(parent));
		System.out.println(anw);
	}
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa!=pb) {
			if(pa<pb) parent[pb]=pa;
			else parent[pa]=pb;
		}
	}
	private static int find(int a) {
		if(a==parent[a]) {
			return a;
		}
		return parent[a]=find(parent[a]);
	}
}
