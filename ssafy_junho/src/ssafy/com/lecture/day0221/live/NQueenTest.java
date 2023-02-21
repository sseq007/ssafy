package ssafy.com.lecture.day0221.live;

import java.util.Scanner;

public class NQueenTest {

	static int n, col[], answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		
		col = new int[n+1];
		
		setQueen(1);
		System.out.println(answer);
		
	}
	
	private static void setQueen(int rowNo) {
		if(!isAvailable(rowNo-1)) return;
		
		if(rowNo>n) {
			answer ++;
			return;
		}
		
		for (int c = 1; c <=n; c++) {
			col[rowNo] = c;
			setQueen(rowNo+1);
		}
	}

	private static boolean isAvailable(int rowNo) {
		for (int i = 1; i < rowNo; i++) {
			if(col[i]==col[rowNo] || Math.abs(col[i]-col[rowNo])==rowNo-i ) return false;
		}
		return true;
	}
}
