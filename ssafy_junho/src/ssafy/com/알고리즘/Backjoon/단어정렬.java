package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 단어정렬 {
	
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		
		for (int i = 0; i < n; i++) {
			arr[i]=br.readLine();
		}
		Arrays.sort(arr,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) { 
					return o1.compareTo(o2);
					
				}else {
					return o1.length()-o2.length();
				}
			}
		});
		for (int i = 0; i < arr.length-1; i++) {
			if(!arr[i].equals(arr[i+1])) {
				System.out.println(arr[i]);
			}
		}
		System.out.println(arr[n-1]);
	}
}
