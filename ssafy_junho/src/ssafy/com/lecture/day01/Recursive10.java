package ssafy.com.lecture.day01;

import java.util.Arrays;

/*
 * 0 ~ 2 ������ �� 3�� ���� ���α׷��� ���ϼ���
 * �� �ߺ��ؼ� ���� �ִ�.
 * 
 * ����
 * */
public class Recursive10 {

	
	public static void main(String[] args) {
		int[] arr = {1,3,5};
		
		recursive(arr,new int[3],0,new boolean[arr.length]);
	}

	/*
	 * arr[] : ���� �迭
	 * sel[] : ��� �迭
	 * k : ��¹迭 �ε���
	 * v[] : ��뿩��
	 * */
	private static void recursive(int[]arr,int[] sel, int k,boolean[] v ) {
		//basis part
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			
			return;
		}
		
		//inductive part
		for(int i=0;i<arr.length;i++) {
			if(!v[i]) {
				v[i]=true;
				sel[k]=arr[i];
				recursive(arr,sel, k+1,v);
				v[i]=false;
			}
		}
		
		
		
	}
}


