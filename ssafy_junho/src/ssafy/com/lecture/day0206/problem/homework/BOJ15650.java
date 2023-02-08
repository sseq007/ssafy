package ssafy.com.lecture.day0206.problem.homework;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N�� M(2)
/*
 * ����(�ߺ�X,��������)
 * 
 * */
public class BOJ15650 {

	static StringBuilder sb= new StringBuilder();
	static int[] arr;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		
		recur(1,0);
		System.out.println(sb);
	}

	/*
	 * arr[] : ��� �迭
	 * d : ��¹迭 �ε���
	 * s : �迭 ���� �ε���
	 * 
	 * */
	public static void recur(int s, int d) {
		//basis part
		if(d==arr.length) {
			for(int i=0; i<arr.length;i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//inductive part
		for(int i=s;i<=n;i++) {
			arr[d]=i;
			recur(i+1,d+1);
		}
	}

	
}
