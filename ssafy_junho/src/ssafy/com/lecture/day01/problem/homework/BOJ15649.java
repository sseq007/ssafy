package ssafy.com.lecture.day01.problem.homework;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N�� M(1)
/*
 * ����(�ߺ�X)
 * 
 * */
public class BOJ15649 {

	static StringBuilder sb= new StringBuilder();
	static int[] arr;
	static boolean[] visited;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visited = new boolean[n+1];
		recur(0);
		System.out.println(sb);
	}
	
	/*
	 * arr[] : ��� �迭
	 * d : ��¹迭 �ε���
	 * visited[] : ��뿩��
	 * */

	public static void recur(int d) {
		//basic part
		if(d==arr.length) {
			for(int i=0; i<arr.length;i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//inductive part
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[d]=i;
				recur(d+1);
				visited[i]=false;
			}
		}
	}
}
