package ssafy.com.lecture.day0228.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class 최소스패닝트리  {

	static int v,e;
	static long sum,cnt;
	static StringTokenizer st;
	static int[] parents;
	static ArrayList<Edge> edges;
	static class Edge implements Comparable<Edge>{
		int s,e,c;

		public Edge(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.c, o.c);
		}
		
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in))) ;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			edges = new ArrayList<>();
			parents = new int[v+1];
			for (int i = 1; i < parents.length; i++) {
				parents[i]=i;
			}
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
				
			}
			cnt=0;
			sum=0;
			Collections.sort(edges);
			for (int i = 0; i < edges.size(); i++) {
				Edge edge = edges.get(i);
				// 순환이 아니라면
				if(find(edge.s) != find(edge.e)){
					union(edge.s, edge.e);
					cnt++;
					sum+=edge.c;
					if(cnt==v-1) break;
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
		
	}
	private static int find(int s) {
		if(parents[s]==s) return s;
		// pathj compression
		else return parents[s]=find(parents[s]);
		
	}
	private static void union(int s, int e) {
		int ps = find(s);
		int pe = find(e);
		if(ps != pe) {
			parents[ps] = pe;
		}
		
	}
}
