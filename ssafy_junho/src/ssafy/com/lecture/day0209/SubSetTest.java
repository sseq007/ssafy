package ssafy.com.lecture.day0209;

import java.util.Arrays;
import java.util.Scanner;

public class SubSetTest {

	static int n,totalCnt;
	static int[] input; // 입력받은 수들
	static boolean[] isSelected; // 각 원소가 부분집합의 구성에 포함되었는지를 여부
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		input = new int[n];
		isSelected = new boolean[n];
		
		for(int i=0;i<n;i++) {
			input[i] = sc.nextInt();
		}
		generateSubSet(0);
	}
	private static void generateSubSet(int cnt) { // cnt : 직전까지 고려된 원소 수
		if(cnt == n) {
			System.out.println(Arrays.toString(isSelected));
			return;
		}
		
		//현재 원소를 부분집합의 구성에 포함
		isSelected[cnt] = true;
		generateSubSet(cnt+1);
//		System.out.println(cnt);
		isSelected[cnt]= false;
		//현재 원소를 부분집합의 구성에 비포함
		generateSubSet(cnt+1);
	}
	
	
}
