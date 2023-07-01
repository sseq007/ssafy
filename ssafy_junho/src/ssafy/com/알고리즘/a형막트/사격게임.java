package ssafy.com.알고리즘.a형막트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 사격게임 {

	static class Point{
		int val,index,bomb;

		public Point(int val, int index, int bomb) {
			super();
			this.val = val;
			this.index = index;
			this.bomb = bomb;
		}

		@Override
		public String toString() {
			return "Point [val=" + val + ", index=" + index + ", bomb=" + bomb + "]";
		}
	}
	static int n;
	static Point[] ball;
	static Point[] copyball;
	static int[] sel;
	static boolean[] v;
	static int max_score;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			
			n = Integer.parseInt(br.readLine());
			ball = new Point[n];
			v = new boolean[n];
			sel = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				ball[i]=new Point(Integer.parseInt(st.nextToken()),i,0);
			}
			max_score=Integer.MIN_VALUE;
			recur(0);
			System.out.println("#"+tc+" "+max_score);
			
			
		}
	}
	private static void recur(int idx) {
		if(idx==n) {
			
			copyball= new Point[n];
			copy(copyball);

			int score=0;
			for (int i = 0; i < sel.length; i++) {
				int x = sel[i];
				//우로 이웃한 경우
				if(checkbombright(x)&&checkbombnow()) {
					for (int j = x+1; j < n; j++) {
						if(copyball[j].bomb==0) {
							score+=copyball[j].val;
							break;
						}
					}
					copyball[x].bomb=1;
				}
				//좌로 이웃한 경우
				else if (checkbombleft(x)&&checkbombnow()) {
					
					for (int j = x-1; j >= 0; j--) {
						if(copyball[j].bomb==0) {
							score+=copyball[j].val;
							break;
						}
					}
					copyball[x].bomb=1;
				}
				//양쪽으로 이웃한 경우
				else if (checkbomb(x)) {
					int left=0;
					int right=0;
					for (int j = x-1; j >= 0; j--) {
						if(copyball[j].bomb==0) {
							left = copyball[j].val;
							break;
						}
					}
					for (int j = x+1; j < n; j++) {
						if(copyball[j].bomb==0) {
							right = copyball[j].val;
							break;
						}
					}
					copyball[x].bomb=1;
					
					score+=(left*right);
					
				}
				//혼자인 경우
				else  {
					score+=copyball[x].val;
				}
			}
			
			max_score=Math.max(max_score, score);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(!v[i]) {
				v[i]=true;
				sel[idx]=i;
				recur(idx+1);
				v[i]=false;
			}
		}
		
	}
	private static boolean checkbombnow() {
		int cnt=0;
		for (int i = 0; i < n; i++) {
			if(copyball[i].bomb==0) {
				cnt++;
			}
		}
		if(cnt>=2) return true;
		return false;
	}
	private static boolean checkbombleft(int x) {
		for (int i = x+1; i < n; i++) {
			if(copyball[i].bomb==0) {
				return false;
			}
		}
		return true;
	}
	private static boolean checkbombright(int x) {
		for (int i = x-1; i >= 0; i--) {
			if(copyball[i].bomb==0) {
				return false;
			}
		}
		return true;
	}
	private static boolean checkbomb(int x) {
		int cnt=0;
		for (int i = x+1; i < n; i++) {
			if(copyball[i].bomb==0) { 
				cnt++;
			break;
			}
		}
		for (int i = x-1; i >= 0; i--) {
			if(copyball[i].bomb==0) {
				cnt++;
				break;
			}
	
		}
		if(cnt==2) {
			return true;
		}
		return false;
	}
	private static void copy(Point[] copyball) {
		for (int i = 0; i < n; i++) {
	        copyball[i] = new Point(ball[i].val, ball[i].index, ball[i].bomb);
	    }
		
	}
}
