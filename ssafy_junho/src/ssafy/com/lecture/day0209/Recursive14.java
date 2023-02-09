package ssafy.com.lecture.day0209;

import java.util.Arrays;

/*
 * �迭�� �� 3���� 2�� ���� ���α׷��� ���ϼ���
 * 
 * ��Ʈ ����
 * */
public class Recursive14 {

	static int cnt=0;
	public static void main(String[] args) {
		int[] arr = {1,3,5};
		
		recursive(arr,new int[3],0,0);
		System.out.println("����� �� :"+cnt);
	}
	/*
	 * arr[] : ���� �迭
	 * sel[] : ��� �迭
	 * d : ��¹迭 �ε���
	 * bit: ��뿩�� �迭
	 * 
	 * */
	
	private static void recursive(int[] arr, int[] sel, int k, int bit) {
		//basis part
		if(k == sel.length) {
			System.out.println(Arrays.toString(sel));
			cnt+=1;
			return;
		}
		
		//inductive part
		
		for(int i=0;i<arr.length;i++) {
			
			if((bit&1<<i)==0) {
				
				sel[k]=arr[i];
				recursive(arr, sel, k+1, bit|1<<i);
			}
		}
		
		
	}

	
}
