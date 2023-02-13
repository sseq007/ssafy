package ssafy.com.lecture.day0213.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1일, 1달, 3달, 1년
 * 
 * */
public class 수영장 {

	static int[] price;
	static month_plan[] plan;
	static StringTokenizer st;
	static boolean[] sel;
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {			
			st = new StringTokenizer(br.readLine());
			price = new int[4];
			plan = new month_plan[12];
			sel = new boolean[3];
			for(int i=0;i<4;i++) {
				price[i]= Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<12;i++) {
				plan[i]=new month_plan(i+1,Integer.parseInt(st.nextToken()));
			}
			
			recur(0);
			
			
			
			
		}
		
	}
	private static void recur(int idx) {
		if(idx==sel.length) {
//			System.out.print(Arrays.toString(sel));
			buy();
			return;
		}
		
		sel[idx]=true;
		recur(idx+1);
		sel[idx]=false;
		recur(idx+1);
		
	}
	private static void buy() {
		for(int i=0;i<sel.length;i++) {
			if(sel[i]==true) {
				
			}
		}
		
	}
}

class month_plan{
	int month;
	int use_n;
	public month_plan(int month, int use_n) {
		super();
		this.month = month;
		this.use_n = use_n;
	}
	
}
