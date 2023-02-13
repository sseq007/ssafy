package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//상근이의 여행
public class Problem9372 {

	static LinkedList<Integer>[] list;
	static Queue<Integer> q;
	static StringTokenizer st;
	static boolean[] v;
	static int min;
	static int cnt;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			list = new LinkedList[n+1];
			
			for(int i=0;i<n+1;i++) {
				list[i]= new LinkedList<Integer>();
			}
			v= new boolean[n+1];
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			cnt=0;
			min = Integer.MAX_VALUE;
			for(int i=1;i<n+1;i++) {
				dfs(i);
				System.out.println(cnt);
				min = Math.min(cnt, min);
				
			}
			
			System.out.println(min);
		}
		
	}
	private static void dfs(int i) {			
		
//		System.out.println(cnt);
		v[i]=true;
		
		Iterator<Integer> it = list[i].iterator();
//		System.out.println(i);
		while(it.hasNext()) {
			int next = it.next();
			if(!v[next]) {
			dfs(next);
			cnt++;
//			v[next]= false;
			}
		}
	}
}
