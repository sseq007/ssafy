package ssafy.com.알고리즘.a형막트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇개척자솔루 {

	static class Seed{
		int state;
		int k=3;
		int day;
		
		void init() {
			state = 0;
			k=3;
			day=0;
		}
	}
	static int n,m;
	static Seed[][] map;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			st = new  StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new Seed[n][n];
			
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				for (int j = 0,idx=0; j < n; j++,idx+=2) {
					if(input.charAt(idx)=='0') {
						map[i][j]= new Seed();
					}
				}
			}
			
			int maxget=Integer.MIN_VALUE;
			
			for (int i = 1; i < n-1; i++) {
				for (int j = 1; j < n-1; j++) {
					if(map[i][j]==null) continue;
					for (int d = 0; d < 4; d++) {
						int getcnt=move(i,j,d);
						maxget=Math.max(maxget, getcnt);
						initseed();
					}
				}
			}
			System.out.println("#"+tc+" "+maxget);
			
			
		}
	}
	private static void initseed() {
		for (int i = 1; i < n-1; i++) {
			for (int j = 1; j < n-1; j++) {
				if(map[i][j]!=null) {
					map[i][j].init();
				}
			}
		}
		
	}
	private static int move(int x, int y, int d) {
		int getcnt = 0;
		int nx=-1;
		int ny=-1;
		for (int day = 0; day < m; day++) {
			boolean moveable = false;
			for (int i = 0; i < dy.length; i++) {
				int tempd = (i+d)%4;
				nx = x+dx[tempd];
				ny = y+dy[tempd];
				
				if(map[nx][ny]!=null&&map[nx][ny].state!=1&&map[nx][ny].state!=2) {
					d = (d+i+3)%4;
					moveable=true;
					break;
				}
			}
			Seed s = map[x][y];
			
			if(s!=null&&s.state==0&&moveable) {
				s.state=1;
			}else if(s!=null&&s.state==0&&!moveable) {
				
			}else if(s!=null&&s.state==3) {
				getcnt++;
				s.state=0;
			}
			
			if(moveable) {
				x = nx;
				y= ny;
			}
			
			for (int i = 1; i < n-1; i++) {
				for (int j = 1; j < n-1; j++) {
					s = map[i][j];
					if(s==null) continue;
					if(s.state==1) {
						s.state=2;
						s.k++;
					}else if (s.state==2) {
						s.day++;
						if(s.day==s.k) {
							s.state=3;
							s.day=0;
						}
					}
				}
			}
			
		}
		
		return getcnt;
	}
}
