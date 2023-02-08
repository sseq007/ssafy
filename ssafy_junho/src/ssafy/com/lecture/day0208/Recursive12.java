package ssafy.com.lecture.day0208;

import java.util.Arrays;

/*
 * �迭�� �� 3���� 2�� ���� ���α׷��� ���ϼ���
 * 
 * �ߺ�����
 * */
public class Recursive12 {

	static int cnt=0;
	public static void main(String[] args) {
		int[] arr = {1,3,5};
		
		recursive(arr,new int[2],0,0);
		System.out.println("����� �� :"+cnt);
	}
	/*
	 * arr[] : ���� �迭
	 * sel[] : ��� �迭
	 * s : �����迭 �ε���
	 * d : ��¹迭 �ε���
	 * 
	 * */
	private static void recursive(int[] arr, int[] sel, int s, int d) {
		//basis part
		if(d == sel.length) {
			System.out.println(Arrays.toString(sel));
			cnt+=1;
			return;
		}
		
		//inductive part
		
		for(int i=s;i<arr.length;i++) {
			sel[d]=arr[i];
			recursive(arr, sel, i, d+1);
		}
		
		
	}

	
}
