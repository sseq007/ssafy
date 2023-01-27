package 알고리즘스터디;

import java.util.Scanner;

//소금쟁이 중첩
public class Problem21 {

	//소금쟁이 뛰는 햇수 for() 3번 2번 1번
	//방향(하:1,우:2)
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc =1;tc<=T;tc++) {
			int n = sc.nextInt(); // 연못 크기
			int salt_n = sc.nextInt(); // 소금쟁이 수
			int[][] board = new int[n][n]; // 0초기화
			
			
			int[][] salt_info = new int[salt_n][3];
			for (int i = 0; i < salt_n; i++) {
				for (int j = 0; j < 3; j++) {
					salt_info[i][j] = sc.nextInt();
				}
			}
			
			int result=0;
			int state=0;
			int[] stop= new int[salt_n];
			
			for(int a=3;a>=1;a--) {
				for (int i = 0; i < salt_info.length; i++) {
					
					int x= salt_info[i][0];
					int y =salt_info[i][1];
					int dir = salt_info[i][2];
					if(board[x][y]==0) {
						board[x][y]=1;
					}
					
					if(dir==1) {
						
						if(board[x+a][y]==1) {
							result=i+1;
							state=1;
							break;
						}
						
						if(jump_down(x,y,a,n,board)==0) {
							break;
						}
						salt_info[i][0]=jump_down(x,y,a,n,board);
						
						
							salt_info[i][0]=jump_down(x,y,0,n,board);
						
					}
					else {
						if(board[x][y+a]==1) {
							result=i+1;
							state=1;
							break;
						}
						if(y+a>=n) {
							System.out.println("-1");
							stop[i]=1;
						}
						
						if(stop[i]==0) {
						salt_info[i][1]=jump_right(x,y,a,n,board);
						}
						else {
						salt_info[i][1]=jump_right(x,y,0,n,board);
						}
						
					}
					
			}
			if(state==1) {
				break;
			}
			
			
		}
			System.out.println("#"+tc+" "+result);
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
	}
}

	private static int jump_right(int x, int y, int a, int n, int[][] board) {
		
		int dy = y;
		dy=dy+a;
		if(dy<n) {
			board[x][dy]=1;
			return dy;
		}else return 0;
			
		
	}

	private static int jump_down(int x, int y,int a, int n,int[][] board) {
			
			int dx =x;
			dx=dx+a;
			if(dx<n) {
				board[dx][y]=1;
				return dx;
			}else return 0;
			
	}
	
}
