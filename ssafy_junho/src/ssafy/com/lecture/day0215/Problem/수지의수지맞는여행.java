package ssafy.com.lecture.day0215.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 수지의수지맞는여행 {

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static char[][] map;
	static int r,c;
	static boolean[][]v;
	static StringTokenizer st;
	static int cnt;
	static ArrayList<Character> arr;
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new char[r][c];
			for(int i=0;i<r;i++) {
				String str = br.readLine();
				for(int j=0;j<c;j++) {
					map[i][j]=str.charAt(j);
				}
			}
			arr = new ArrayList<Character>();
			v= new boolean[r][c];
			v[0][0]=true;
			dfs(0,0,1);
			System.out.println(arr.toString());
			
		}
	}
	private static void dfs(int x, int y,int cnt) {
		//basis part
		if(check(x,y)) {
			System.out.println(arr.toString());
			System.out.println(cnt);
			return;
		}
		
		System.out.println(arr.toString());
		for(int i=0;i<4;i++) {
			int nr = x+dr[i];
			int nc = y+dc[i];
			if(0<=nr&&nr<r&&0<=nc&&nc<c&&!v[nr][nc]&&check(nr,nc)) {
				v[nr][nc]=true;
				dfs(nr, nc, cnt+1);
				v[nr][nc]=false;
				
			}
		}
		
	}
	private static boolean check(int nr,int nc) {
		for(int i=0;i<arr.size();i++) {
			if(map[nr][nc]==arr.get(i)) return false;
		}
		return true;
	}
	
}
