package ssafy.com.lecture.day01;
/*
 * ��͸� �̿��Ͽ� �迭�� ��Ұ��� �հ� ���� ���ϼ���
 * �� �Լ��� ���ڴ� (idx,val)���θ� �����ϼ���
 * */
public class Recursive07 {
	static int[] arr = {1,3,5};
	public static void main(String[] args) {
		
		
		recursive(0,1);
		
		
	}
	private static void recursive(int idx,int val) {
		//basis part
		if(idx == arr.length) {
			System.out.println(val);
			return;
		}
		//logic part
		// inductive part
//		int tmp = val;
		
		
		recursive(idx+1, val+arr[idx]);
	
		recursive(idx+1, val*arr[idx]);
		
		
	
	}
}
