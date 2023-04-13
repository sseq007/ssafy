package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

//BOJ 17144
public class 미세먼지안녕 {
	static class Point{
		int x,y,val;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		};
		
		
	}
	static int n,m,t;
	static ArrayList<Point> robot;
	static ArrayList<Point> dust;
	static int[][] map;
	static int[][] copyMap;
	static List<Point>[][] list;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		robot = new ArrayList();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					robot.add(new Point(i, j));
				}
				
			}
		}
		int Time = 0;
		while(Time<t) {
			//미세먼지 확산하기
			spreadDust();
			//공기청정기 작동
//			print(map);
			//바람 위에 작동
			workrobot();
//			print(map);
			Time++;
		}
		int sum=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]>0) {
					sum+=map[i][j];
				}
			}
		}
		System.out.println(sum);
	}
	private static void workrobot() {
		
		int upx = robot.get(0).x;
		int upy = robot.get(0).y;
		int downx = robot.get(1).x;
		int downy = robot.get(1).y;
		//위 구역 바람 작동
		//아래
		for (int i = upx-1; i >0; i--) {
			map[i][0]=map[i-1][0];
		}
		//왼쪽
		for (int i = 0; i < m-1; i++) {
			map[0][i]=map[0][i+1];
		}
		//위
		for (int i = 0; i < upx; i++) {
			map[i][m-1]=map[i+1][m-1];
		}
		//오른쪽
		for (int i = m-1; i >1; i--) {
			map[upx][i]=map[upx][i-1];
		}
		map[upx][1]=0;
		//위 구역 바람 작동
		//위
		for (int i = downx+1; i < n-1; i++) {
			map[i][0]=map[i+1][0];
		}
		//왼쪽
		for (int i = 0; i < m-1; i++) {
			map[n-1][i]=map[n-1][i+1];
		}
		//아래
		for (int i = n-1; i >downx; i--) {
			map[i][m-1]=map[i-1][m-1];
		}
		//오른쪽
		for (int i = m-1; i >1; i--) {
			map[downx][i]=map[downx][i-1];
		}
		map[downx][1]=0;
		
		
		
	}
	private static void print(int[][] copyMap2) {
		for (int i = 0; i < copyMap2.length; i++) {
			for (int j = 0; j < copyMap2[i].length; j++) {
				System.out.print(copyMap2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("================");
		
	}
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,-0,1,-1};
	private static void spreadDust() {
		dust = new ArrayList();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]!=-1&&map[i][j]!=0) {
					dust.add(new Point(i, j, map[i][j]));
				}
			}
		}
		
		copyMap = new int[n][m];
		for (int i = 0; i < dust.size(); i++) {
			int dirCnt=0;
			for (int d = 0; d < 4; d++) {
				int nx = dust.get(i).x+dx[d];
				int ny = dust.get(i).y+dy[d];
				//범위를 벗어나면
				if(0>nx||0>ny||nx>=n||ny>=m) continue;
				//로봇을 만나면
				if(map[nx][ny]==-1) continue;
				//확산할 수 있는 방향 수 세기
				dirCnt++;
				//확산 되는 양은 나누기 5
				int spreadVal = map[dust.get(i).x][dust.get(i).y]/5;
				//확산하기
				copyMap[nx][ny]+=spreadVal;
				
			}
			//확산할 수 없으면
			if(dirCnt==0) continue;
			//확산되고 남은 미세먼지 양
			int outdust = (map[dust.get(i).x][dust.get(i).y]/5)*dirCnt;
			copyMap[dust.get(i).x][dust.get(i).y]+=map[dust.get(i).x][dust.get(i).y]-outdust;
			
		}
		copyMap[robot.get(0).x][robot.get(0).y]=-1;
		copyMap[robot.get(1).x][robot.get(1).y]=-1;
		
		map = copyMap;
		
	}
}
