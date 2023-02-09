package ssafy.com.lecture.day0209.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//햄버거 다이어트 -> 부분집합으로 풀기
public class SWEA5215 {
	static int n,l;
	static burger[] arr;
	static StringTokenizer st;
	static boolean[] sel;
	static int max_score;
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			sel = new boolean[n];
			arr = new burger[n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new burger(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			
			max_score=0;
			recur(0,0,0);
			System.out.println("#"+tc+" "+max_score);
			
			
		}
	}
	private static void recur(int idx, int total_score,int total_kcal) {
		
		if(idx==sel.length) {
			int sum=0;
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					total_score+=arr[i].score;
					total_kcal+=arr[i].kcal;
				}
			}
			if(total_kcal<=l) {
				max_score=Math.max(total_score, max_score);
			}
//			System.out.println(Arrays.toString(sel));
			return;
		}
		
		sel[idx]=true;
		recur(idx+1, total_score, total_kcal);
		sel[idx]=false;
		recur(idx+1, total_score, total_kcal);
	}
}
class burger{
	int score;
	int kcal;
	public burger(int score, int kcal) {
		
		this.score = score;
		this.kcal = kcal;
		
	}
	
}
