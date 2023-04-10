package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 에너지모으기 {
	static int n,weight;
	static int[] w;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		weight = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		
		recur(arr,0);
		System.out.println(weight);
	}
	private static void recur(ArrayList<Integer> arr, int sum) {
		if(arr.size()==2) {
			weight = Math.max(sum, weight);
			return;
		}
		for (int i = 1; i < arr.size()-1; i++) {
			int tmp = arr.get(i);
			int num  = arr.get(i-1)*arr.get(i+1);
			arr.remove(i);
			recur(arr, sum+num);
			arr.add(i, tmp);
		}
	}
	

}
