package ssafy.com.lecture.day01;
/*
 * ��͸� �̿��Ͽ� �迭�� ��Ұ��� ���� ���ϼ���
 * 
 * */
public class Recursive04 {
	static int sum=0;
	static int[] arr = {1,3,5};
	public static void main(String[] args) {
		
		
		System.out.println(recursive(0));
		
	}
	private static int recursive(int idx) {
		//basis part
		if(idx == arr.length) {
		//	System.out.println(sum);
			return 0;
		}
		//logic part
		// inductive part
		
		return recursive(idx+1)+arr[idx];
	}
}
