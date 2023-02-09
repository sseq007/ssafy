package ssafy.com.lecture.day0209;

import java.util.Arrays;
import java.util.Scanner;

public class SubSetSumTest {

	static int n,s,totalCnt;
	static int[] input; // 입력받은 수들
	static boolean[] isSelected; // 각 원소가 부분집합의 구성에 포함되었는지를 여부
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		input = new int[n];
		isSelected = new boolean[n];
		
		for(int i=0;i<n;i++) {
			input[i] = sc.nextInt();
		}
		generateSubSet(0,0);
	}
//	private static void generateSubSet(int cnt) { // cnt : 직전까지 고려된 원소 수
//		if(cnt == n) {
//			int sum=0;
//			//부분집합의 요소들의 합구하기
//			for(int i=0;i<n;i++) {
//				if(isSelected[i]) sum+=input[i];
//			}
//			if(sum==s) {
//				totalCnt++;			
//				for(int i=0;i<n;i++)
//				System.out.print(input[i]);
//			}
//			return;
//		}
//		
//		//현재 원소를 부분집합의 구성에 포함
//		isSelected[cnt] = true;
//		generateSubSet(cnt+1);
////		System.out.println(cnt);
//		isSelected[cnt]= false;
//		//현재 원소를 부분집합의 구성에 비포함
//		generateSubSet(cnt+1);
//	}
	
	private static void generateSubSet(int cnt,int sum) { // cnt : 직전까지 고려된 원소 수
		if(cnt == n) {									// sum : 직전까지 선택된 원소들의 합
			if(sum==s) {
				totalCnt++;			
				for(int i=0;i<n;i++)
					if(isSelected[i]) System.out.print(input[i]);
			}
			return;
		}
		
		//현재 원소를 부분집합의 구성에 포함
		isSelected[cnt] = true;
		generateSubSet(cnt+1,sum+input[cnt]);
//		System.out.println(cnt);
		isSelected[cnt]= false;
		//현재 원소를 부분집합의 구성에 비포함
		generateSubSet(cnt+1,sum);
	}
	
}
