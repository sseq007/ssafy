package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

//BOJ 1722
public class 순열의순서 {

	static int n,q,k,cnt,anw2;
	static String a;
	static ArrayList<Integer> anw1;
	static int[] nums;
	static int[] sel;
	static boolean[] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		q = Integer.parseInt(st.nextToken());
		nums = new int[n];
		anw1 = new ArrayList<Integer>();
		sel = new int[n+1];
		v = new boolean[n+1];
		if(q==1) {
			k = Integer.parseInt(st.nextToken());
			recur(1);
			for (int i = 0; i < anw1.size(); i++) {
				System.out.print(anw1.get(i)+" ");
			}
		}else {
			a="";
			for (int i = 0; i < n; i++) {
				nums[i]=Integer.parseInt(st.nextToken());
				a+=Integer.toString(nums[i]);
			}
			recur(1);
			System.out.println(anw2);
		}
		
		
		
	}
	private static void recur(int idx) {
		if(idx==sel.length) {
			cnt++;
//			System.out.println(Arrays.toString(sel));
//			System.out.println(cnt);
			if(cnt==k) {
				for (int i = 1; i <=n ; i++) {
					anw1.add(sel[i]);
				}
			}
			String b= "";
			for (int i = 1; i <=n; i++) {
				b+=Integer.toString(sel[i]);
			}
			if(a.equals(b)) {
				anw2=cnt;
			}
			return;
		}
		
		for (int i = 1; i <=n; i++) {
			if(!v[i]) {
				v[i]=true;
				sel[idx]=i;
				recur(idx+1);
				v[i]=false;
			}
		}
	}
}
