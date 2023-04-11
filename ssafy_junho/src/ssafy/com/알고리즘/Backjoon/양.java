package ssafy.com.알고리즘.Backjoon;
//BOJ 3184
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양 {
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,-0,1,-1};
	static int n,m,wolf_n,sheep_n,wn,sn;
	static char[][] map;
	static boolean[][] v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map= new char[n][m];
		v= new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j]=input.charAt(j);
				if(map[i][j]=='v') {
					wolf_n++;
				}
				if(map[i][j]=='o') {
					sheep_n++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]!='#'&&!v[i][j]) {
					wn=0;
					sn=0;
					v[i][j]=true;
					if(map[i][j]=='o') {
						sn++;
					}else if(map[i][j]=='v') {
						wn++;
					}
					dfs(i,j);
//					System.out.printf("%d %d\n",wn,sn);
					if(wn>=sn) {
						sheep_n-=sn;
					}else {
						wolf_n-=wn;
					}
				}
			}
		}
		System.out.printf("%d %d",sheep_n,wolf_n);
		
		
	}
	private static void dfs(int x, int y) {
		
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0<=nx&&0<=ny&&nx<n&&ny<m&&!v[nx][ny]&&map[nx][ny]!='#') {
				v[nx][ny]=true;
				if(map[nx][ny]=='v') {
					wn++;
				}else if(map[nx][ny]=='o') {
					sn++;
				}
				dfs(nx, ny);
//				v[nx][ny]=false;
				
			}
		}
	}
}
