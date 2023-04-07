package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 봄버맨2 {
	
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int r,c,n;
	static char[][] map;
	static int[][] bombtime;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map= new char[r][c];
		bombtime= new int[r][c];
		for (int i = 0; i < r; i++) {
			String input = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j]=input.charAt(j);
				if(map[i][j]=='O') {
					bombtime[i][j]=3;
				}
			}
		}
		if(n==1) {
			print(map);
			System.exit(0);
			
		}
		int time =0;
		time++;
		if(n%2==0) {
			n =2;
		}else if(n%4==3) {
			n=3;
		}else if(n%4==1) {
			n=5;
		}
		
		while(time<n) {
			time++;
			//짝수 일떄
			if(time%2==0) {
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if(map[i][j]=='.') {
							map[i][j]='O';
							bombtime[i][j]=time+3;
						}
					}
				}
				
			}
			//홀수 일떄
			else {
				//폭탄 bomb
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if(bombtime[i][j]==time) {
							map[i][j]='.';
							for (int d = 0; d < 4; d++) {
								int nx = i+dx[d];
								int ny = j+dy[d];
								if(0>nx||0>ny||nx>=r||ny>=c) continue;
								if(map[nx][ny]=='O'&&time!=bombtime[nx][ny]) {
									bombtime[nx][ny]=0;
									map[nx][ny]='.';
								}
								
							}
						
						}
						
						
					}
				}
				
					
					
				}
//			print(bombtime);
			
		}
		print(map);
		
	}
	private static void print(char[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
}
