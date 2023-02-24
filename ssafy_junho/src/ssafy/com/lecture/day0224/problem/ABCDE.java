package ssafy.com.lecture.day0224.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ABCDE {

	static int n,m;
	static LinkedList<Integer>[] graph;
	static StringTokenizer st;
	static boolean[] v;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new LinkedList[n];
		v = new boolean[n];
		for(int i=0;i<n;i++) {
			graph[i]= new LinkedList<Integer>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b); 
			graph[b].add(a); 
		}
		
		
		for(int i=0;i<n;i++) {
			flag =false;
			v[i]=true;
			dfs(i,0);
			v[i]=false;
			if(flag) { 
				System.out.println(1);
				break;
			}
		}
		if(!flag) System.out.println(0);
		
	}
	private static void dfs(int x,int idx) {

		if(idx==4) {
			flag=true;
			return;
		}
		
		
		Iterator<Integer> iter = graph[x].listIterator();
		
		while(iter.hasNext()) {
			int next = iter.next();
			
			if(!v[next]) {
				v[next]=true;
				dfs(next, idx+1);
				v[next]=false;
			}
		}
		
	}
}
