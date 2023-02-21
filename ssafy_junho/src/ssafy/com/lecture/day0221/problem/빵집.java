package ssafy.com.lecture.day0221.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집 {

	static int r,c;
	static char[][] map;
	static StringTokenizer st;
	static boolean flag;
	static int [] dx= {-1,0,1};
	static int [] dy= {1,1,1};
	static int anw;
	public static void main(String[] args) throws Exception {
		
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	st = new StringTokenizer(br.readLine());
	r = Integer.parseInt(st.nextToken());
	c = Integer.parseInt(st.nextToken());
	map = new char[r][c];
	for(int i=0;i<r;i++) {
		String str = br.readLine();
		for(int j=0;j<c;j++) {
			map[i][j]= str.charAt(j);
		}
	}
	
	for(int i=0;i<r;i++) {
		flag= false;
		recur(i,0);	
		}
	System.out.println(anw);
	}
	

	private static void recur(int x, int y) {
		//속도 향상
//		if(flag) {
//			return;
//		}
		
		
		if(y==c-1) {
			anw++;
			flag= true;
			return;
		}
		
		for(int d = 0;d<3;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx>=0&&nx<r&&ny>=0&&ny<c&&map[nx][ny]=='.'&&!flag) {
				map[nx][ny]='x';
				recur(nx, ny);
			}
		}
	}
	
	
}
