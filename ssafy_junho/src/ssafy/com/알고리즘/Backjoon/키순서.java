package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class 키순서 {
	static int n,m,cnt;
	static List<Integer>[] list;
	static boolean[] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		for (int i = 1; i <=n; i++) {
			list[i]= new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		
		for (int i = 1; i <=n; i++) {
			v = new boolean[n+1];
			cnt=0;
			v[i]=true;
			bigDfs(i);
		}
		
	}
	private static void bigDfs(int x) {
		
		for (List<Integer> list2 : list) {
		}
	}
	
}
