package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 숫자고르기 {
	static int n;
	static List<Integer>[] list;
	static int[] arr;
	static boolean[] v;
	static ArrayList<Integer> data;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		v = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		list = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		for (int i = 1; i <=n ; i++) {
			int a = i;
			int b = arr[i];
			list[a].add(b);
			list[b].add(a);
		}
		data  = new ArrayList<Integer>();
		for (int i = 1; i <=n; i++) {
			v[i]=true;
			dfs(i,i);
			v[i]=false;
		}
		Collections.sort(data);
		System.out.println(data.size());
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
		
	}
	private static void dfs(int x, int k) {
		
		if(!v[arr[x]]) {
			v[arr[x]]=true;
			dfs(arr[x], k);
			v[arr[x]]=false;
		}
		if(arr[x]==k) {
			data.add(k);
		}
	}
}
