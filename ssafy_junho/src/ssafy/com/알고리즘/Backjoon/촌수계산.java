package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

//BOJ 2644
public class 촌수계산 {

	static List<Integer>[] graph;
	static int n,targetA,targetB,m,anw=-1;
	static boolean[] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		targetA=Integer.parseInt(st.nextToken());
		targetB=Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		graph = new List[n+1];
		v= new boolean[n+1];
		
		for (int i = 1; i <=n; i++) {
			graph[i]= new  ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		dfs(targetA,targetB,0);
		System.out.println(anw);
	}
	private static void dfs(int x, int y, int cnt) {
		
		if(x==y) {
			anw=cnt;
			return;
		}
		
		v[x]=true;
		
		Iterator<Integer> iter = graph[x].iterator();
		
		while(iter.hasNext()) {
			int next = iter.next();
			if(!v[next]) {
				dfs(next, y, cnt+1);
			}
		}
		
	}
}
