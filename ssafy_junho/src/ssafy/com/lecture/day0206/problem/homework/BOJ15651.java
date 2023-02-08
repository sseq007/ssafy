package ssafy.com.lecture.day0206.problem.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N�� M(3)
/*
 * �ߺ� ����
 * */
public class BOJ15651 {

	static int n,m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		
		recur(0);
		
		System.out.println(sb);
		
	}
	/*
	 * arr[] : ��� �迭
	 * d : ��¹迭 �ε���
	 * 
	 * */


	private static void recur(int d) {
		//basis part
		if(d==arr.length) {
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//inductive part
		for(int i=1;i<=n;i++) {
			arr[d]=i;
			recur(d+1);
		}
	}
}
