package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 창용마을무리의개수 {

	static int n,m,cnt;
	static LinkedList<Integer>[] list;
	static boolean[] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			n= Integer.parseInt(st.nextToken());
			m= Integer.parseInt(st.nextToken());
			
			list = new LinkedList[n+1];
			v = new boolean[n+1];
			cnt=0;
			for (int i = 1; i <n+1 ; i++) {
				list[i]= new LinkedList<Integer>();
			}
			for (int i = 1; i <m+1 ; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			for (int i = 1; i < n+1; i++) {
				if(!v[i]) {
//					dfs(i);
					bfs(i);
					cnt++;
				}
			}
			System.out.println("#"+tc+" "+cnt);
			
		}
	}
	private static void dfs(int x) {
		v[x]=true;
		
		Iterator<Integer> iter = list[x].listIterator();
		
		while(iter.hasNext()) {
			int next = iter.next();
			if(!v[next]) {
				dfs(next);
			}
		}
	}
	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(x);
		v[x]=true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			Iterator<Integer> iter = list[cur].listIterator();
			while(iter.hasNext()) {
				int next = iter.next();
				if(!v[next]) {
					v[next]=true;
					q.offer(next);
				}
			}
		}
	}
}
