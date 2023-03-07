package ssafy.com.lecture;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test2 {

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] map;
	static StringTokenizer st;
	static int N, Ans = Integer.MAX_VALUE, MaxApple;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("apple.txt")));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			Ans = Integer.MAX_VALUE;
			MaxApple = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0) {
						MaxApple = Math.max(MaxApple, map[i][j]);
					}
				}
			}

			print(map);

			dfs(0, 0, 0, 0, 1);

			// System.out.println(cnt);
			System.out.println(Ans);
		}
	}

	static boolean flag = false;

	private static void dfs(int r, int c, int d, int cnt, int eat) {
//		if (flag)
//			return;
		System.out.printf("%d %d %d %d %d \n", r, c, d, cnt, eat);
		if (MaxApple == eat - 1) {
			Ans = Math.min(Ans, cnt);
			//flag = true;
			return;
		}

		int nr = r + dr[d];
		int nc = c + dc[d];

		// 1. 꺽어서 사과가 있는가
		// 2. 벽을 만나며
		// 꺽는다
		if (check(r, c, d, eat) || (nr < 0 || nr >= N && nc < 0 || nc >= N)) {
			d = (d + 1) % 4;
			dfs(r, c, d, cnt + 1, eat);
			return;
		}
		// 그냥 가는가
		// 사과를 먹는가
		// if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
		if (map[r][c] == eat) {
			// 먹어 .................
			dfs(r, c, d, cnt, eat + 1);
		} else {
			// 전진..............
			dfs(nr, nc, d, cnt, eat);
		}
		// }
	}

	private static boolean check(int r, int c, int d, int eat) {
		d = (d + 1) % 4;
		while (r >= 0 && r < N && c >= 0 && c < N) {
			r += dr[d];
			c += dc[d];
			if (r >= 0 && r < N && c >= 0 && c < N) {
				if (map[r][c] == eat) {
					return true;
				}
			}
		}
		return false;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}
}
