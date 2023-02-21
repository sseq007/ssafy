package ssafy.com.lecture.day0221.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 월드컵 {
	static StringTokenizer st;
	static Country[] c;
	static class Country{
		int win;
		int same;
		int lose;
		public Country(int win, int same, int lose) {
			super();
			this.win = win;
			this.same = same;
			this.lose = lose;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0;t<4;t++) {
			c = new Country[6];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<6;i++) {
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				int d= Integer.parseInt(st.nextToken());
				c[i]= new Country(a, b, d);
			}
			
			
			recur(0,0,0);
		}
		
		
		
		
	}
	private static void recur(int w,int d,int l) {

	
		if(w+d+l>=5) {
			return;
		}
		
		recur(w+1, d, l);
		recur(w, d+1, l);
		recur(w, d, l+1);

		
	}
}
