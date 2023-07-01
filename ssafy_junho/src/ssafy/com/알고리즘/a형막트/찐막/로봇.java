package ssafy.com.알고리즘.a형막트.찐막;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇 {

	static class Seed{
		int state;
		int k =3;
		int day;
		void init() {
			state=0;
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new Seed[n][n];
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				for (int j = 0,index=0; j < n; j++,index+=2) {
					if(input.charAt(index)=='0') {
						map[i][j] = new Seed();
					}
				}
			}
			int maxgetSeed=0;
			for (int i = 1; i < n-1; i++) {
				for (int j = 1; j < n-1; j++) {
					if(map[i][j]==null) continue;
					for (int d = 0; d < 4; d++) {
						int totalSeed = go(i,j,d);
						maxgetSeed = Math.max(maxgetSeed, totalSeed);
						initseed();
					}
					}
				}
			System.out.println("#"+tc+" "+maxgetSeed);
			}
			
			
		}
	private static void initseed() {
		for (int i = 1; i < n-1; i++) {
			for (int j = 1; j < n-1; j++) {
				if(map[i][j]==null) continue;
				map[i][j].init();
			}
		}
		
	}
	private static int go(int x, int y, int d) {
		int totalSeed = 0;
		int nx=-1;
		int ny=-1;
		for (int day = 0; day < m; day++) {
			boolean moveable = false;
			for (int i = 0; i < dy.length; i++) {
				int tempd = (i+d)%4;
				nx =x+dx[tempd];
				ny =y+dy[tempd];
				if(map[nx][ny]!=null&&map[nx][ny].state!=1&&map[nx][ny].state!=2) {
					moveable=true;
					d = (d+i+3)%4;
					break;
				}
			}
			
			Seed s = map[x][y];
			if(s!=null&&s.state==0&&moveable) {
				s.state=1;
			}else if(s!=null&&s.state==0&&!moveable) {
				
			}else if(s!=null&&s.state==3) {
				totalSeed++;
				s.state=0;
			}
			if(moveable) {
				x = nx;
				y = ny;
			}
			for (int i = 1; i <n-1; i++) {
				for (int j = 1; j <n-1; j++) {
					s=map[i][j];
					if(s==null) continue;
					if(s.state==1) {
						s.state=2;
						s.k++;
					}else if (s.state==2) {
						s.day++;
						if(s.day==s.k) {
							s.day=0;
							s.state=3;
						}
					}
					
				}
			}
			 
		}
		return totalSeed;
	}
		
	}
	
	
	

