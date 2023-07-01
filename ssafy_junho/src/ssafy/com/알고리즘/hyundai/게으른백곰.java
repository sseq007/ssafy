package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//BOJ 10025
public class 게으른백곰 {

	static class Point{
		int val,idx;

		public Point(int val, int idx) {
			super();
			this.val = val;
			this.idx = idx;
		}
		
		
		
	}
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Point[] arr = new Point[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i]= new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return Integer.compare(o1.idx, o2.idx);
			}
		});
		int left = 0;
		int right=0;
		int sum=0;
		int result=0;
		int w = (2*k)+1;
		
		while(true) {
			if(arr[right].idx-arr[left].idx<=w) {
				sum+=arr[right].val;
				right++;
				result = Math.max(result, sum);
			}else {
				sum-=arr[left].val;
				left++;
			}
			if(right>=n) break;
		}
		System.out.println(result);
	}
}
