package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ 15565
public class 귀여운라이언 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] num = new int [n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		int left=0;
		int right=0;
		int result=Integer.MAX_VALUE;
		int sum=0;
		int size=0;
		boolean lFlag=false;
		boolean rFlag= true;
		for (int i = 0; i < num.length; i++) {
			if(num[i]==1) {
				left = i;
				right = i;
				break;
			}
		}
		while(true) {
			if(left>=n||right>=n) break;
		
			if(rFlag&&num[right]==1) {
				sum++;
				if(sum==k) {
					sum--;
					lFlag=true;
					rFlag=false;
					size = right-left+1;
					result = Math.min(result, size);
				}
			}else if(lFlag&&num[left]==1) {
				lFlag=false;
				rFlag=true;
			}
				
			if(lFlag) left++;
			else right++;
				
		}
		System.out.println(result==Integer.MAX_VALUE?-1:result);
				
	}
}
