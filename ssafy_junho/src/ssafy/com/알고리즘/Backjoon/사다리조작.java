package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 사다리조작 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int n,m,h;
	static int[][] ladder;
	static int[][] sel;
	static StringTokenizer st;
	static int ladder_n;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		ladder = new int[h+1][n+1];
		
		for (int i = 0; i <m; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			ladder[a][b]=1;
			ladder[a][b+1]=2;
		}
		flag = false;
		for (int i = 0; i <= 3; i++) {
			ladder_n=i;
			dfs(1,0);
			if(flag) break;
		}
		System.out.println(flag==false?-1:ladder_n);
		
	}
	private static void dfs(int idx, int cnt) {
		if(flag) return;
		if(cnt==ladder_n) {
			System.out.println(cnt);
			print(ladder);
			if(check()) flag = true;
			
			return;
		}
		
		for (int i = idx; i <=h; i++) {
			for (int j = 1; j < n; j++) {
				if(ladder[i][j]==0&&ladder[i][j+1]==0) {
					ladder[i][j]=1;
					ladder[i][j+1]=2;
					dfs(i, cnt+1);
					ladder[i][j]=0;
					ladder[i][j+1]=0;
					
					
				}
			}
		}
	}
	private static boolean check() {
		for (int i = 1; i <=n ; i++) {
			int x= 1; int y = i;
			for (int j = 0; j <h; j++) {
				if(ladder[x][y]==1)y++;
				else if(ladder[x][y]==2)y--;
				x++;
			}
			if(y!=i) return false;
		}
		return true;
	}
	private static void print(int[][] ladder2) {
		for (int i = 0; i < ladder2.length; i++) {
			for (int j = 0; j < ladder2[i].length; j++) {
				System.out.print(ladder2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}
}
