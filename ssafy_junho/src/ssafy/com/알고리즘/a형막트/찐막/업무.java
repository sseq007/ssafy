package ssafy.com.알고리즘.a형막트.찐막;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 업무 {

	static ArrayList<Integer>[] pre;
	static int n;
	static int[] time;
	static int[] memo;
	static boolean[] v;
	static boolean cycle;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			pre = new ArrayList[n + 1];
			time = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				time[i] = Integer.parseInt(st.nextToken());
				pre[i] = new ArrayList<Integer>();
				int m = Integer.parseInt(st.nextToken());

				for (int j = 0; j < m; j++) {
					pre[i].add(Integer.parseInt(st.nextToken()));
				}

			}

			int mintotalTime = Integer.MAX_VALUE;
			cycle = false;

			for (int i = 1; i <= n; i++) {
				memo = new int[n + 1];
				v = new boolean[n + 1];
				int total = 0;
				loop: for (int j = 1; j <= n; j++) {
					v[j] = true;
					int jTime = check(j, i);
					v[j] = false;
					if (cycle) {
						mintotalTime = -1;
						break loop;
					}
					total = Math.max(total, jTime);
				}
				mintotalTime = Math.min(mintotalTime, total);
			}
			System.out.println("#" + tc + " " + mintotalTime);

		}
	}

	private static int check(int index, int help) {
		if (cycle)
			return -1;
		if (memo[index] > 0)
			return memo[index];

		int pretotalTime = 0;

		for (int i = 0; i < pre[index].size(); i++) {
			if (v[pre[index].get(i)]) {
				cycle = true;
				return  0;
			}

			v[pre[index].get(i)] = true;
			int workTime = check(pre[index].get(i), help);
			pretotalTime = Math.max(pretotalTime, workTime);
			v[pre[index].get(i)] = false;

		}

		return memo[index] =pretotalTime+ (index == help ? time[index] / 2 : time[index]);
	}
}
