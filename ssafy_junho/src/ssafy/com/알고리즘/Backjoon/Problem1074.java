package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Z
public class Problem1074 {

	static int[][] arr;
	static int n,r,c,new_idx;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[(int) Math.pow(2, n)][(int) Math.pow(2, n)];
		
		new_idx = (int) Math.pow(2, n-1);
		
		dfs(0,0,0);
		
		
	}
	private static void dfs(int x,int y,int count) {
		if(x==r&&y==c) {
			return;
		}
		if(n==1) {
			return;
		}
		
		if(x<new_idx&&y<new_idx)
		arr[x][y]=count;
		arr[x][y+1]=count+1;
		arr[x+1][y]=count+2;
		arr[x+1][y+1]=count+3;
		
//		dfs(x+2);
//		
		
	}
	

}
