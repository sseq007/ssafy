package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 줄어드는수 {

	static int n;
	static ArrayList<Long> arr;
	static int[] nums = {9,8,7,6,5,4,3,2,1,0};
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		arr = new ArrayList<Long>();
		
		
		recur(0,0);
		
		Collections.sort(arr);
		
		if(n>=1023) {
			System.out.println(-1);
		}
		else System.out.println(arr.get(n-1));
		System.out.println(arr.toString());
		
	}
	private static void recur(int idx,long val) {
		
		//중복되는 값 제거
		if(!arr.contains(val)) {
			arr.add(val);
			
		}
		//basis part
		if(idx==10) {
//			System.out.println(arr.toString());
			return;
		}
		
		//inductive part
		recur(idx+1, val*10+nums[idx]);
		recur(idx+1, val);
		
		
		
	}
}
