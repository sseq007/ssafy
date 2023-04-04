package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 페그솔리테어 {

	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int n;
	static char[][] map;
	static int pin_n,move_n,anw_pin;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < n; tc++) {
			pin_n=0;
			move_n=0;
			map= new char[5][9];
			for (int i = 0; i < 5; i++) {
				String input = br.readLine();
				for (int j = 0; j < 9; j++) {
					map[i][j]=input.charAt(j);
					if(map[i][j]=='o') pin_n++;
					
				}
			}
			anw_pin= pin_n;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 9; j++) {
					if(map[i][j]=='o') {
						dfs(i,j,pin_n,0);
					}
				}
			}
			System.out.printf("%d %d\n",anw_pin,move_n);
			br.readLine();
		}
		
		
	}
	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}
	private static void dfs(int x, int y, int pinN, int moveN) {
		if(anw_pin>=pinN) {
			anw_pin=pinN;
			move_n=moveN;
//			System.out.println("핀개수"+pinN);
//			System.out.println("움직임"+moveN);
//			print(map);
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0<=nx&&0<=ny&&nx<5&&ny<9&&map[nx][ny]=='o') {
				int nnx = nx+dx[d];
				int nny = ny+dy[d];
				if(0<=nnx&&0<=nny&&nnx<5&&nny<9&&map[nnx][nny]=='.') {
					map[x][y]='.';
					map[nx][ny]='.';
					map[nnx][nny]='o';
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 9; j++) {
							if(map[i][j]=='o') {
								dfs(i,j,pinN-1,moveN+1);
							}
						}
					}
					
					map[nnx][nny]='.';
					map[nx][ny]='o';
					map[x][y]='o';
				}
			}
			
		}
		
		
	}
}
