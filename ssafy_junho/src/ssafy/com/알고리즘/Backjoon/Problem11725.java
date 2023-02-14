package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//������� ����
public class Problem11725 {

	static LinkedList<Integer>[] list;
	static Queue<Integer> q;
	static StringTokenizer st;
	static int[] v;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int n = Integer.parseInt(br.readLine());
			list = new LinkedList[n+1];
			
			for(int i=0;i<n+1;i++) {
				list[i]= new LinkedList<Integer>();
			}
			v= new int[n+1];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
				dfs(1);
				
			}
			
		
	private static void dfs(int i) {			
		
		Iterator<Integer> it = list[i].iterator();
		System.out.println(i);
		while(it.hasNext()) {
			int next = it.next();
			if(v[next]==0) {
				v[i]=next;
				dfs(next);
			}
		}
	}
}
