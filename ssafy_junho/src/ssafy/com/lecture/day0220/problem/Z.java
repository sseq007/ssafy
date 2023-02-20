package ssafy.com.lecture.day0220.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {

	static int n,r,c;
	static int[][] map;
	static int result;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, n);
		map = new int[size][size];
		result=0;
		cut(0,0,size);
		System.out.println(result);
		
		
	}
	private static void cut(int x, int y, int size) {
		if(size==1) {
			return;
		}
		
		if(r<x+size/2&&c<y+size/2) {
			cut(x, y, size/2);
		}
		else if(r<x+size/2&&c>=y+size/2) {
			result+=Math.pow(size/2,2);
			cut(x, y+size/2, size/2);
			
		}else if(r>=x+size/2&&c<y+size/2) {
			result+=Math.pow(size/2,2)*2;
			cut(x+size/2, y, size/2);
			
		}else if(r>=x+size/2&&c>=y+size/2){
			result+=Math.pow(size/2,2)*3;
			cut(x+size/2, y+size/2, size/2);
		}
	}
}
