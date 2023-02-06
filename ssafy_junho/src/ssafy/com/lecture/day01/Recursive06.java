package ssafy.com.lecture.day01;

import java.util.Arrays;

/*
 * �迭��Ұ��� 2���� �̾� ����ϼ���.(����)
 * 
 * */
public class Recursive06 {
	
	//���� �迭
	static int[] arr = {1,3,5};
	//����迭
	static int[] sel = new int[2];
	public static void main(String[] args) {
			

		recursive(0,0);
		
	}
	/*
	 * idx : �����迭�� �ε���
	 * k : ����迭�� �ε���
	 * */
	
	private static void recursive(int idx, int k) {
		//basis part
		
		//2���� �� �̾����� �׸�
 		if(k==sel.length) {
 			System.out.println(Arrays.toString(sel));
			return;
		}
 		//���̻� ������ ���� ���
 		if(idx==arr.length) return;
		
		//inductive part
		//�����ϴ� ���
		sel[k]=arr[idx];
		recursive(idx+1, k+1);
		
		//�������� �ʴ� ���
		recursive(idx+1, k);
	}
	
}
