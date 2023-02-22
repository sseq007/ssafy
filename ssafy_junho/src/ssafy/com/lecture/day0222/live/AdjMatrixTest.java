package ssafy.com.lecture.day0222.live;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjMatrixTest {

	static int[][] adjMatrix;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		adjMatrix = new int[v][v];
		
		int from,to;
		for(int i=0;i<e;i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			// 무향 그래프
			adjMatrix[to][from]=adjMatrix[from][to] =1;	
		}
		print();
		
	}
	static void print() {
		for (int[] am : adjMatrix) {
			System.out.println(Arrays.toString(am));
		}
	}
}
