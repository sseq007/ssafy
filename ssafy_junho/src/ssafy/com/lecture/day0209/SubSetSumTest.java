package ssafy.com.lecture.day0209;

import java.util.Arrays;
import java.util.Scanner;

public class SubSetSumTest {

	static int n,s,totalCnt;
	static int[] input; // �Է¹��� ����
	static boolean[] isSelected; // �� ���Ұ� �κ������� ������ ���ԵǾ������� ����
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
//	private static void generateSubSet(int cnt) { // cnt : �������� ����� ���� ��
//		if(cnt == n) {
//			int sum=0;
//			//�κ������� ��ҵ��� �ձ��ϱ�
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
//		//���� ���Ҹ� �κ������� ������ ����
//		isSelected[cnt] = true;
//		generateSubSet(cnt+1);
////		System.out.println(cnt);
//		isSelected[cnt]= false;
//		//���� ���Ҹ� �κ������� ������ ������
//		generateSubSet(cnt+1);
//	}
	
	private static void generateSubSet(int cnt,int sum) { // cnt : �������� ����� ���� ��
		if(cnt == n) {									// sum : �������� ���õ� ���ҵ��� ��
			if(sum==s) {
				totalCnt++;			
				for(int i=0;i<n;i++)
					if(isSelected[i]) System.out.print(input[i]);
			}
			return;
		}
		
		//���� ���Ҹ� �κ������� ������ ����
		isSelected[cnt] = true;
		generateSubSet(cnt+1,sum+input[cnt]);
//		System.out.println(cnt);
		isSelected[cnt]= false;
		//���� ���Ҹ� �κ������� ������ ������
		generateSubSet(cnt+1,sum);
	}
	
}
