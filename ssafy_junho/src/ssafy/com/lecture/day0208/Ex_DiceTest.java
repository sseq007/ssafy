package ssafy.com.lecture.day0208;

import java.util.Arrays;
import java.util.Scanner;

//�Է����� �ֻ��������� ��带 �޴´�(1,2,3,4)
//������ �ֻ��� ���� �Է¹޴´�. (1<=N<=10)
public class Ex_DiceTest {

	static int n;
	static int[] numbers;
	static boolean[] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt();
		n = sc.nextInt();
		
		numbers = new int[n];
		visited = new boolean[7];
		switch(mode) {
		case 1: // �ߺ� ����
			dice1(0);
			break;
		
		case 2: // ����
			dice2(0);
			break;
		case 3: //�ߺ� ����
			dice3(1,0);
			break;
		case 4: // ����
			dice4(0,1);
			break;
		}
		
		
		
	}
	private static void dice4(int d, int s) {
		if(d==numbers.length) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=s;i<=6;i++) {
			numbers[d]=i;
			dice4(d+1,i+1);
		}
		
	}
	private static void dice3(int s, int d) {
		if(d==numbers.length) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=s;i<=6;i++) {
			numbers[d]=i;
			dice3(i,d+1);
		}
		
	}
	private static void dice1(int d) {
		if(d==numbers.length) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=1;i<=6;i++) {
			numbers[d]=i;
			dice1(d+1);
		}
	}
	private static void dice2(int d) {
		
		if(d==numbers.length) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i =1;i<=6;i++) {
			if(!visited[i]) {
				visited[i]=true;
				numbers[d]=i;
				dice2(d+1);
				visited[i]=false;
			}
		}
	}
}
