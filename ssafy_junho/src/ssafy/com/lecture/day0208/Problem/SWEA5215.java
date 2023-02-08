package ssafy.com.lecture.day0208.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//햄버거 다이어트
public class SWEA5215 {
	static int n,l;
	static burger[] arr;
	static StringTokenizer st;
	static int[] sel;
	static int max_score;
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			sel = new int[n];
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
	private static void recur(int s, int total_score,int total_kcal) {
		
		if(total_kcal>l) {
			
			return;
		}
		
		max_score=Math.max(total_score, max_score);
		for(int i=s;i<n;i++) {
			
			recur(i+1,total_score+arr[i].score, total_kcal+arr[i].kcal);
		}
		
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
