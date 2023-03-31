package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1 {
	static int n;
	static int[][] map;
	static int[][] memo;
	static int[][] cnt;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		memo = new int[n][n];
		cnt = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
//		recur(0,1,0);
//		System.out.println(cnt[n-1][n-1]);
		recur(0,1,0);
		
	}
	private static int recur(int x, int y, int state) {
		// TODO Auto-generated method stub
		if(x==n-1&&y==n-1) {
			return 1;
		}
		if(memo[x][y]!=0) {
			return memo[x][y];
		}
//		print(memo);
		
		if(x>=0&&y>=0&&x<n&&y<n&&map[x][y]==0) {
			if(state==0) {
				memo[x][y]+=recur(x, y+1, 0);
				memo[x][y]+=recur(x+1, y+1, 2);
			}
			//state= 1 세로
			else if(state==1) {
				memo[x][y]+=recur(x+1, y, 1);
				memo[x][y]+=recur(x+1, y+1, 2);
			}
			//state= 2 대각선
			else if(state==2) {
				if(map[x][y-1]==0&&map[x-1][y]==0) {
					
					memo[x][y]+=recur(x, y+1, 0);
					memo[x][y]+=recur(x+1, y, 1);
					memo[x][y]+=recur(x+1, y+1, 2);
				}
				}

		}
		return memo[x][y];
	}
	
	
//	if(x==n-1&&y==m-1) {
//		
//		return 1;
//	}
//	if(memo[x][y]!=-1) {
//		return memo[x][y];
//	}
//	memo[x][y]=0;
//	
//	for (int d = 0; d < 4; d++) {
//		int nx = x+dx[d];
//		int ny = y+dy[d];
//		if(0>nx||0>ny||nx>=n||ny>=m) continue;
//		if(map[x][y]<=map[nx][ny]) continue;
//		
//		memo[x][y]+=dfs(nx, ny);
//	}
//	return memo[x][y];
//	private static void recur(int x, int y,int state) {
//		
//		if(x<0||y<0||x>=n||y>=n) return;
//		if(map[x][y]==1) return;
//		//state= 0 가로
//		if(state==0) {
//			recur(x, y+1, 0);
//			recur(x+1, y+1, 2);
//		}
//		//state= 1 세로
//		else if(state==1) {
//			recur(x+1, y, 1);
//			recur(x+1, y+1, 2);
//		}
//		//state= 2 대각선
//		else if(state==2) {
//			if(map[x][y-1]==1||map[x-1][y]==1) return;
//			recur(x, y+1, 0);
//			recur(x+1, y, 1);
//			recur(x+1, y+1, 2);
//		}
//		cnt[x][y]++;
//		
//	}
	private static void print(int[][] memo) {
		for (int i = 0; i < cnt.length; i++) {
			for (int j = 0; j < cnt[i].length; j++) {
				System.out.print(cnt[i][j]+" ");
			}
			System.out.println();
		}
	}
}
