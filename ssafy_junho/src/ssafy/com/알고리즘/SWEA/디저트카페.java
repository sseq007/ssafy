package ssafy.com.알고리즘.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 2105
public class 디저트카페 {

	static int n, start_x, start_y, max_depth;;
	static int[][] map;
	static boolean[] dessertType;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dessertType = new boolean[101];
			max_depth = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dessertType[map[i][j]] = true;
					start_x = i;
					start_y = j;
					dfs(i, j, 0, 0);
					dessertType[map[i][j]] = false;
				}
			}

			int anw = max_depth == Integer.MIN_VALUE ? -1 : max_depth;
			System.out.println("#" + tc + " " + anw);

		}
	}

	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };

	private static void dfs(int x, int y, int dir, int depth) {
		// 사각형을 이루면
		if(dir==4) {
			if (depth != 0 && start_x == x && start_y == y) {
				max_depth = Math.max(depth, max_depth);
			}
			return;
		}
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		// 범위를 벗어나면
		if (0 > nx || 0 > ny || nx >= n || ny >= n) return;
		// 디저트종류가 같으면
		if (dessertType[map[nx][ny]]) return;

		dessertType[map[nx][ny]] = true;
		dfs(nx, ny, dir+1, depth + 1);
		dfs(nx, ny, dir, depth + 1);
		dessertType[map[nx][ny]] = false;

	}
}
