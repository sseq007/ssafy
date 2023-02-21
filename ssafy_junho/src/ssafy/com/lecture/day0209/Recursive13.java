package ssafy.com.lecture.day0209;

import java.util.Arrays;

/*
 * �迭�� �κ����� ���ϱ� --> �κ����� = ������ ��� ����
 * 
 * 
 * */
public class Recursive13 {

	static int cnt=0;
	public static void main(String[] args) {
		int[] arr = {1,3,5};
		
		recursive(arr,new boolean[arr.length],0,0);
		System.out.println("����� �� :"+cnt);
	}
	
	/*
	 * arr[] : ���� �迭 sel[] : ��� �迭 s : �����迭 �ε���
	 * 
	 */
	private static void recursive(int[] arr, boolean[] sel, int idx, int k) {
		// basis part
		if (idx == arr.length) {
			System.out.println(Arrays.toString(sel));

			for (int i = 0; i < sel.length; i++) {
				if (k == 2) {
					if (sel[i]) {
						System.out.print("true :" + arr[i] + " ");
					}
//				else {
//					System.out.print("false :"+arr[i]+" ");					
//				}
				}
			}
			System.out.println();
			return;
		}

		//inductive part
		
		
		sel[idx]= true;
		recursive(arr, sel, idx+1,k+1);
		sel[idx]=false;
		recursive(arr, sel, idx+1,k);
		
	}

	
}
