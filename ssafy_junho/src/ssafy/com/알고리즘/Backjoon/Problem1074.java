package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Z
/*
 * ��͸� ���� size�� 2�� ������ 4�������� ������
 * ��Ģ
 * 1��и� -> size����*1
 * 2��и� -> 0
 * 3��и� -> size����*2
 * 4��и� -> size����*3
 * */
public class Problem1074 {

	static int n,r,c,result;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		result=0;
		int size = (int) Math.pow(2, n);
		recur(0,0,size);
		
		System.out.println(result);
		
		
	}
	private static void recur(int x,int y,int size) {
		
		if(size ==1) {
			return;
		}
		
		//2��и��ϋ�
		if(r<x+size/2&&c<y+size/2) {
			recur(x, y, size/2);
		}
		
		//1��и��ϋ�
		if(r<x+size/2&&c>=y+size/2) {
			result+=(int)Math.pow(size/2, 2);
			recur(x, y+size/2, size/2);
		}
		//3��и��ϋ�
		if(r>=x+size/2&&c<y+size/2) {
			result+=(int)Math.pow(size/2, 2)*2;
			recur(x+size/2, y, size/2);
		}
		//4��и��϶�
		if(r>=x+size/2&&c>=y+size/2) {
			result+=(int)Math.pow(size/2, 2)*3;
			recur(x+size/2, y+size/2, size/2);
		}
	}
	

}
