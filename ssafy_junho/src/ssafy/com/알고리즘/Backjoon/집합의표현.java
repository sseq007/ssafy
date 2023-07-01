package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현 {
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <=n; i++) {
			parents[i]=i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//합집합
			if(cmd==0) {
				union(a,b);
			}else if(cmd==1) {
				if(find(a)!=find(b)) {
					sb.append("NO").append("\n");
				}else {
					sb.append("YES").append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

	private static int  find(int a) {
		if(a==parents[a]) {
			return a;
		}
		return parents[a]=find(parents[a]);
	}

	private static void union(int a, int b) {

		int pa = find(a);
		int pb = find(b);
		if(pa!=pb) parents[pb]=pa;
	}
}
