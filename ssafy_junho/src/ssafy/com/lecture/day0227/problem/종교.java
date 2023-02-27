package ssafy.com.lecture.day0227.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종교 {
	static int n,m,cnt;
	static int[] parents;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		
		//make set
		for (int i = 1; i < n; i++) {
			parents[i]=i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a=  Integer.parseInt(st.nextToken());
			int b=  Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		for (int i = 0; i < parents.length; i++) {
			if(parents[i]==i) cnt++;
		}
		System.out.println(cnt);
		
	}
	private static void union(int a, int b) {
		
		int pa = find(a);
		int pb = find(b);
		
		if(pa!=pb) {
			parents[pa]=parents[pb];
		}
		
	}
	private static int find(int b) {
		if(parents[b] == b) return b;
		else return find(parents[b]);
	}
}
