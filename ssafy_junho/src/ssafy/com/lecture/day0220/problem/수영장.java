package ssafy.com.lecture.day0220.problem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장 {

	static int[] price;
	static int[] plan;
	static StringTokenizer st;
	static int min;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			price =new int[4];
			plan = new int[12];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				price[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<12;i++) {
				plan[i]=Integer.parseInt(st.nextToken());
			}
			int year_sum = price[3];
			
			recur(0,0);
			int result = min<year_sum?min:year_sum;
			System.out.println("#"+tc+" "+ result);
		}
	}
	private static void recur(int idx, int val) {

		if(idx>=12) {
			min = Math.min(min, val);
//			System.out.println(min);
			return;
		}
		
		if(plan[idx]==0) {
			recur(idx+1, val);
		}
		else {
			recur(idx+1, val+(price[0]*plan[idx]));
			recur(idx+1, val+price[1]);
			recur(idx+3, val+price[2]);
		}
	}
}
