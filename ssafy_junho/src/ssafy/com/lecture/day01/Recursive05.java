package ssafy.com.lecture.day01;
/*
 * ��͸� �̿��Ͽ� �迭�� ��Ұ��� �հ� ���� ���ϼ���
 * 
 * */
public class Recursive05 {
	static int sum=0;
	static int mul=1;
	static int[] arr = {1,3,5};
	public static void main(String[] args) {
		
		recursive(0);
		
		
	}
	private static void recursive(int idx) {
		//basis part
		if(idx == arr.length) {
			System.out.println(sum);
			System.out.println(mul);
			return;
		}
		//logic part
		// inductive part
		sum+=arr[idx];
		mul*=arr[idx];
		recursive(idx+1);
	}
}
