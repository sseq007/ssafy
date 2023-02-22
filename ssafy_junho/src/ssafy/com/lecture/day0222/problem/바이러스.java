package ssafy.com.lecture.day0222.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 바이러스 {
	
	static LinkedList<Integer>[] list;
	static StringTokenizer st;
	static int n,m;
	static boolean[] v;
	static int cnt;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new LinkedList[n+1];
		v= new boolean[n+1];
		cnt=0;
		for(int i=1;i<n+1;i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for (int i = 1; i<m+1; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		recur(1);
		System.out.println(cnt);
	}
	private static void recur(int idx) {
		
		v[idx]=true;
		
		for (int node : list[idx]) {
			if(!v[node]) {
				recur(node);
				cnt++;
			}
		}
		
		
	}
}
