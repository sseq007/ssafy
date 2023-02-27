package ssafy.com.lecture.day0227.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공항 {
	static int G,p,cnt;
	static int[] parents;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		p = Integer.parseInt(br.readLine());
		parents = new int[G+1];
		//make set
		
		for (int i = 0; i < G+1; i++) {
			parents[i]=i;
		}
		
		for (int i = 0; i <p ; i++) {
			int g = Integer.parseInt(br.readLine());
			int pg = find(g);
			if(pg!=0) {
				union(pg,pg-1);
				cnt++;
			}
			else break;
		}
		System.out.println(cnt);
	}
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa!=pb) {
			parents[pa]=parents[pb];
		}	
		
	}
	private static int find(int x) {
		if(parents[x] == x) return x;
		else return parents[x]=find(parents[x]);
	}
}
