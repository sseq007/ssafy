package ssafy.com.lecture.day01;
/*
 * ��͸� �̿��Ͽ� �迭�� ��Ұ��� ������
 * 
 * */
public class Recursive02 {
	
	static int[] arr = {1,3,5};
	public static void main(String[] args) {
		
		
		recursive(0);
	}
	private static void recursive(int idx) {
		//basis part
		if(idx == arr.length) {
			return;
		}
		// inductive part
		System.out.println(arr[idx]);
		recursive(idx+1);
	}
}
