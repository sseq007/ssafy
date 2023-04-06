package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 12100
public class 이공사팔 {
	static int n,max_block=0;
	static int[][] map;
	static int[][] copymap;
	static int[] sel;
	static Queue<Integer> q;
	static boolean[]v;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		sel = new int[5];
		v = new boolean[5];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				max_block= max_block>map[i][j]?map[i][j]:max_block;
			}
		}
		//순열 뽑아
		recur(0);
		System.out.println(max_block);
	}
	private static void recur(int idx) {
		if(idx==5) {
			System.out.println(Arrays.toString(sel));
			
			move();
			
			return;
		}
		
		
		for (int i = 1; i <= 4; i++) {
				sel[idx]=i;
				recur(idx+1);
			}
		
	}
	private static void move() {
		copymap = new int[n][n];
//		copy(copymap);
		
		for (int i = 0; i < sel.length; i++) {
			//상
			if(sel[i]==1) {
				move_up(1);
			}
			//하
			else if(sel[i]==2) {
				move_down(2);
			}
			//좌
			else if(sel[i]==3) {
				move_left(3);
			}
			//우
			else {
				move_right(4);
			}
		}
		print(copymap);
		for (int i = 0; i < copymap.length; i++) {
			for (int j = 0; j < copymap[i].length; j++) {
				max_block=Math.max(max_block, copymap[i][j]);
			}
		}
		
	}
	private static void print(int[][] copymap2) {
		for (int i = 0; i < copymap2.length; i++) {
			for (int j = 0; j < copymap2[i].length; j++) {
				System.out.print(copymap2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
		
	}
	private static void move_right(int dir) {
		for (int i = 0; i < n; i++) {
			q = new LinkedList<Integer>();
			int start_val = map[i][n-1];
			for (int j = n-2; j >= 0; j--) {
				int next_val = map[i][j];
				if(start_val!=next_val) {
					q.add(start_val);
					start_val = map[i][j];
					continue;
				}
				int sum_val = start_val+next_val;
				q.add(sum_val);
				
			}
			inputcopyMap(i,dir);
		}
		
	}
	private static void move_left(int dir) {
		for (int i = 0; i < n; i++) {
			q = new LinkedList<Integer>();
			int start_val = map[i][0];
			for (int j = 1; j < n; j++) {
				int next_val = map[i][j];
				if(start_val!=next_val) {
					q.add(start_val);
					start_val = map[i][j];
					continue;
				}
				int sum_val = start_val+next_val;
				q.add(sum_val);
				
			}
			inputcopyMap(i,dir);
		}
		
	}
	private static void move_down(int dir) {
		for (int i = 0; i < n; i++) {
			q = new LinkedList<Integer>();
			int start_val = map[n-1][i];
			for (int j = n-2; j >= 0; j--) {
				int next_val = map[j][i];
				if(start_val==next_val) {
					int sum_val = start_val+next_val;
					q.add(sum_val);
				}
				start_val = map[j][i];
				q.add(start_val);
				
			}
			inputcopyMap(i,dir);
		}
	}
	private static void move_up(int dir) {
		for (int i = 0; i < n; i++) {
			q = new LinkedList<Integer>();
			int start_val = map[0][i];
			for (int j = 1; j < n; j++) {
				int next_val = map[j][i];
				if(start_val!=next_val) {
					q.add(start_val);
					start_val = map[j][i];
					continue;
				}
				int sum_val = start_val+next_val;
				q.add(sum_val);
				
			}
			inputcopyMap(i,dir);
		}
		
	}
	private static void inputcopyMap(int idx , int dir) {
		if(dir==1) {
			int k = 0;
			while(!q.isEmpty()) {
				int now = q.poll();
				copymap[k][idx]=now;
				k++;
			}
			
		}else if(dir==2) {
			int k=n-1;
			while(!q.isEmpty()) {
				int now = q.poll();
				copymap[k][idx]=now;
				k--;
			}
		}else if(dir==3) {
			int k = 0;
			while(!q.isEmpty()) {
				int now = q.poll();
				copymap[idx][k]=now;
				k++;
			}
		}else {
			int k=n-1;
			while(!q.isEmpty()) {
				int now = q.poll();
				copymap[idx][k]=now;
				k--;
			}
		}
			
			
		
		
		
	}
	private static void copy(int[][] copyMap) {
		for (int i = 0; i < copyMap.length; i++) {
			for (int j = 0; j < copyMap[i].length; j++) {
				copyMap[i][j]=map[i][j];
			}
		}
	}
	
}
