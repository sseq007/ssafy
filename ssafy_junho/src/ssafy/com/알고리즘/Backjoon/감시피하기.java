package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 감시피하기 {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int n;
	static boolean[] v;
	static char[][] map;
	static StringTokenizer st;
	static ArrayList<Point> blank;
	static String anw="NO";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map= new char[n][n];
		blank = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]= st.nextToken().charAt(0);
				if(map[i][j]=='X') {
					blank.add(new Point(i, j));
				}
			}
		}
		v = new boolean[blank.size()];
		comb(0,0);
		System.out.println(anw);
	}
	private static void comb(int idx, int s) {
		if(idx==3) {
//			System.out.println(Arrays.toString(v));
			char[][] copyMap = new char[n][n];
			newArray(copyMap);
			for (int i = 0; i < v.length; i++) {
				if(v[i]) {
					copyMap[blank.get(i).x][blank.get(i).y]='O';
				}
			}
//			print(copyMap);
			if(check(copyMap)) {
				anw="YES";
				return;
			}
			
			return;
		}
		
		for (int i = s; i < blank.size(); i++) {
			v[i]=true;
			comb(idx+1, i+1);
			v[i]=false;
		}
		
	}
	private static boolean check(char[][] copyMap) {
		for (int i = 0; i < copyMap.length; i++) {
			for (int j = 0; j < copyMap[i].length; j++) {
				if(copyMap[i][j]=='T') {
					for (int d = 0; d < 4; d++) {
						for (int k = 1; k <n ; k++) {
							int nx = i+dx[d]*k;
							int ny = j+dy[d]*k;
							if(0>nx||nx>=n||0>ny||ny>=n) break;
							if(copyMap[nx][ny]=='O')break;
							if(copyMap[nx][ny]=='S') return false;
							
						}
					}
				}
			}
		}
		return true;
	}
	private static void print(char[][] copyMap) {

		for (int i = 0; i < copyMap.length; i++) {
			for (int j = 0; j < copyMap[i].length; j++) {
				System.out.print(copyMap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
	}
	private static void newArray(char[][] copyMap) {
		for (int i = 0; i < copyMap.length; i++) {
			for (int j = 0; j < copyMap[i].length; j++) {
				copyMap[i][j]=map[i][j];
			}
		}
	}
	
}
