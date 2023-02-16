package ssafy.com.lecture.day0216.live;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationBitTest {

	static int n,r;
	static int[] numbers,input;
	static boolean[] isSelected;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		isSelected = new boolean[n];
		input = new int[n];
		numbers = new int[r];
		
		
		permutation(0,0);
	}
	private static void permutation(int cnt,int flag) {
		if(cnt == r) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=0;i<n;i++) {
			if((flag &(1<<i)) !=0) continue;
			numbers[cnt]= input[i];
			isSelected[i]=true;
			permutation(cnt+1,flag|(1<<i));
			isSelected[i]=false;
		}
	}
}
