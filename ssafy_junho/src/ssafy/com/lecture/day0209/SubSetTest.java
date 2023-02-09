package ssafy.com.lecture.day0209;

import java.util.Arrays;
import java.util.Scanner;

public class SubSetTest {

	static int n,totalCnt;
	static int[] input; // �Է¹��� ����
	static boolean[] isSelected; // �� ���Ұ� �κ������� ������ ���ԵǾ������� ����
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
	private static void generateSubSet(int cnt) { // cnt : �������� ����� ���� ��
		if(cnt == n) {
			System.out.println(Arrays.toString(isSelected));
			return;
		}
		
		//���� ���Ҹ� �κ������� ������ ����
		isSelected[cnt] = true;
		generateSubSet(cnt+1);
//		System.out.println(cnt);
		isSelected[cnt]= false;
		//���� ���Ҹ� �κ������� ������ ������
		generateSubSet(cnt+1);
	}
	
	
}
