package ssafy.com.lecture.day0223.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {

	static int n,k,cnt;
	static StringTokenizer st;
	static int[] arr;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		k= Integer.parseInt(st.nextToken());
		cnt=0;
		arr = new int[1000001];
		v = new boolean[1000001];
		bfs(n);
		System.out.println(cnt);
	}
	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		v[x]=true;
		q.offer(x);
		
		while(!q.isEmpty()) {
			int next = q.poll();
			if(next==k) {
				return;
			}
			for(int i=0;i<3;i++) {
				if(i==0) {
					if(!v[next]) {
						v[next]=true;
						q.offer(next*2);
						cnt++;
					}
				}else if(i==1) {
					if(!v[next]) {
						v[next]=true;
						q.offer(next-1);
						cnt++;
					}
				}else {
					if(!v[next]) {
						v[next]=true;
						q.offer(next+1);
						cnt++;
					}
				}
			}
		}
	}
}
