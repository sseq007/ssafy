package ssafy.com.lecture.day0208.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구간 합 구하기 5
public class Bake11660 {

	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] board = new int[n+1][n+1];
		
		for(int i=1;i<n+1;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=1;j<n+1;j++) {
				board[i][j]=board[i-1][j]+board[i][j-1]+board[i-1][j-1]+Integer.parseInt(st.nextToken());
				
			}
		}
		
		
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<n+1;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		
		
		
	}
}
