package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 결혼식 {

	static int n,m,cnt;
	static List<Integer>[]graph;
	static boolean[] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new List[n+1];
		v = new boolean[n+1];
		for (int i = 1; i <=n; i++) {
			graph[i]=new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		cnt=0;
		v[1]=true;
		dfs(1,1);
		for (int i = 2; i < v.length; i++) {
			if(v[i]) cnt++;
		}
		System.out.println(cnt);
	}
	private static void dfs(int idx,int count) {
		if(count==3) {
			return;
		}
		for (int i = 0; i < graph[idx].size(); i++) {
			int next = graph[idx].get(i);
			v[next]=true;
			dfs(next,count+1);
			
		}
	}
}
