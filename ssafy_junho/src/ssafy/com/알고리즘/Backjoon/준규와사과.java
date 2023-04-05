package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 5913
public class 준규와사과 {
	static int k,targetApple,anw;
	static int[][] map;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		map= new int[5][5];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a-1][b-1]=1;
		}
//		print(map);
		map[0][0]=2;
		dfs(0,0,1);
		
		System.out.println(anw);
		
		
	}
	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println(); 
		}
		System.out.println("------------------------");
		
	}
	static int[] dx= {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	private static void dfs(int x, int y, int cnt) {
		if(x==4&&y==4) {
			
//			print(map);
			if(cnt==25-k) {
				anw++;
			}
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0<=ny&&0<=nx&&ny<5&&nx<5&&map[nx][ny]==0) {
				map[nx][ny]=2;
				dfs(nx, ny, cnt+1);
				map[nx][ny]=0;
			}
		}
		
		
	}
	
			
	
}
