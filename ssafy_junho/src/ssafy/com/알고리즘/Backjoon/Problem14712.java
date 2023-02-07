package ssafy.com.¾Ë°í¸®Áò.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//³Û¸ð³Û¸ð(Easy)
public class Problem14712 {

	static int[][] board;
	static int n,m;
	static int count;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n+1][m+1];
		recur(0,0);
		
		System.out.println(count);
	}
	private static void recur(int x, int y) {
		
		if(x==n&&y==m) {
			count+=1;
			return;
		}
		
		for(int i=x;i<n;i++) { 
			for(int j=y;j<m;j++) {
				if(check(i,j)) {
					count+=1;
				}
			
			
			board[i][j]=1;
			
			recur(x, y+1);
			 board[i][j]=0;
			}
					
					
		}
		
	}
	private static boolean check(int i, int j) {
		if(board[i][j]==1&&board[i+1][j]==1 &&board[i][j+1]==1&&board[i+1][j+1]==1)return true;
		else return false;
	}

}
