package ssafy.com.lecture.day0208.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//∫Ì∑¢¿Ë
public class Baek2798 {

	static int n,m;
	static int[] card;
	static StringTokenizer st;
	static int[] sel;
	static int card_sum,result;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		card = new int[n];
		sel = new int[3];
		card_sum=0;
		result=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			card[i]=Integer.parseInt(st.nextToken());
		}
		
		recur(0,0);
		
		System.out.println(result);
		
	}
	private static void recur(int s, int d) {
		//basis part
		if(d==sel.length) {
//			System.out.println(Arrays.toString(sel));
			int sum=0;
			for(int i=0;i<sel.length;i++) {
				sum+=sel[i];
			}
			if(sum<=m) {
				result = Math.max(sum, result);
			}
			return;
		}
		
		//inductive part
		for(int i=s;i<n;i++) {
			sel[d]=card[i];
			recur(i+1, d+1);
		}
	}
}
