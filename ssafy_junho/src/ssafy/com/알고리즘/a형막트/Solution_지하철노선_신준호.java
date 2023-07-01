package ssafy.com.알고리즘.a형막트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_지하철노선_신준호 {
	static class Point{
		int left,right,idx,val;

		public Point(int left, int right, int idx, int val) {
			super();
			this.left = left;
			this.right = right;
			this.idx = idx;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Point [left=" + left + ", right=" + right + ", idx=" + idx + ", val=" + val + "]";
		}

		
	}
	static int n;
	static int[] sel;
	static int max_val;
	static boolean[] v;
	static Point[] person;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			n = Integer.parseInt(br.readLine());
			person = new Point[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				if(i==0) {
					int left = n-1;
					person[i]=new Point(left, i+1, i,Integer.parseInt(st.nextToken()));
					
				}else if(i==n-1) {
					int right = 0;
					person[i]=new Point(i-1, right,i, Integer.parseInt(st.nextToken()));
				}else {
					person[i]=new Point(i-1, i+1, i,Integer.parseInt(st.nextToken()));
					
				}
			}
			sel = new int[n];
			v = new boolean[n];
			max_val=Integer.MIN_VALUE;
			recur(0);
//			print();
			System.out.println("#"+tc+" "+max_val);
		}
	}
	private static void recur(int idx) {
		if(idx==4) {
//			System.out.println(Arrays.toString(sel));
			//4가지 조건
			Point a = person[sel[0]];
			Point b = person[sel[1]];
			Point c = person[sel[2]];
			Point d = person[sel[3]];
			//2개의 직통 노선은 서로 교차 X
			int min_start = Math.min(a.idx, b.idx);
			int max_end = Math.max(a.idx, b.idx);
			int cnt=0;
			for (int i = min_start+1; i < max_end; i++) {
				if(person[i].idx==c.idx||person[i].idx==d.idx) {
					cnt++;
				}
			}
			if(cnt==1) {
				return;
			}
			//인접한 두 직통 노선 X
			if(a.left==b.idx||a.right==b.idx||b.left==a.idx||b.right==a.idx) return;
			if(c.left==d.idx||c.right==d.idx||d.left==c.idx||d.right==c.idx) return;
			//인접 출발 도착 X
			if(a.left==c.idx||a.right==c.idx||c.left==a.idx||c.right==a.idx) return;
			if(a.left==d.idx||a.right==d.idx||d.left==a.idx||d.right==a.idx) return;
			if(b.left==d.idx||b.right==d.idx||d.left==b.idx||d.right==b.idx) return;
			if(b.left==c.idx||b.right==c.idx||c.left==b.idx||c.right==b.idx) return;
			int total = 0;
			total += Math.pow((a.val+b.val), 2)+Math.pow((c.val+d.val), 2);
			max_val=Math.max(max_val, total);
			
			return;
		}
		for (int i = 0; i < n; i++) {
			if(!v[i]) {
				v[i]=true;
				sel[idx]=i;
				recur(idx+1);
				v[i]=false;
			}
		}
	}
	private static void print() {
		for (int i = 0; i < person.length; i++) {
			System.out.print(person[i].toString()+" ");
		}
		
	}
}
