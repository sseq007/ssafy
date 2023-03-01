package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contact {
	static int n,start_v;
	static LinkedList<Integer>[] graph;
	static int[] v;
	static int max_val;
	static ArrayList<Integer> result;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start_v = Integer.parseInt(st.nextToken());
			graph = new LinkedList[101];
			v = new int[101];
			result = new ArrayList<Integer>();
			for (int i = 1;i < 101; i++) {
				graph[i]=new LinkedList<Integer>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n/2; i++) {
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				graph[a].add(b);
			}
			v[start_v]=1;
			max_val = Integer.MIN_VALUE;
			dfs(start_v);
			for (int i = 1; i < 101; i++) {
				if (max_val == v[i]) {
					result.add(i);
				}
			}
			//System.out.println(Arrays.toString(v));
			// System.out.println(result.toString());
			 System.out.println("#"+tc+" "+result.get(result.size()-1));
		}
	}

	private static void dfs(int x) {

		
		Iterator<Integer> iter = graph[x].listIterator();
		while (iter.hasNext()) {
			int next = iter.next();
			if (v[next] == 0) {
				v[next] = v[x] + 1;
				dfs(next);
				v[next] = v[x] - 1;
				max_val = Math.max(max_val, v[next]);
			}
			
		}
	
	

	}
}

