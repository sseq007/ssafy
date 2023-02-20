package ssafy.com.lecture.day0220.live;

import java.util.Scanner;
/**
 * @author THKim
 */
public class EX_공간만들기 {
	static int white = 0;
	static int green = 0;
	static int[][] spaces;
	
	// 주어진 영역의 공간의 셀 체크하여 모두 초록색이나 하얀색으로 이루어져있는지 확인 후
	// 4개로 쪼개기.
	// 하얀색 0 , 초록색 1
	static void cut(int r, int c, int size) {

		int sum=0;
		for (int i = r,rEnd = r+size; i < rEnd; i++) {
			for(int j=c,cEnd=c+size;j<cEnd;j++) {
				sum+= spaces[i][j];
			}
		}
		if(sum==size*size) { //모두 초록색
			green++;
		}else if (sum==0) { // 모두 하얀색
			white++;
		}else { // 혼합된 상황
			//4분할
			cut(r, c, size/2);
			cut(r, c+size/2, size/2);
			cut(r+size/2, c, size/2);
			cut(r+size/2, c+size/2, size/2);
		}
		
		
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		spaces = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				spaces[i][j] = sc.nextInt();
			}
		}


		cut(0, 0, n);
		
		System.out.println(white);
		System.out.println(green);
		sc.close();
	}
}
