package ssafy.com.lecture.day0206.problem.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[S/W 문제해결 응용] 3일차 - 최적 경로

/*
 * 집, 회사, 고객
 * 
 * 
 * */



public class SWEA1247 {
	
	
	static int n;
	static int min;
	static boolean[] visited;
	static Point1 company,home;
	static Point1[] customer;
	static Point1[] sel;
	
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			visited = new boolean[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new Point1(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			home = new Point1(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			customer = new Point1[n];
			sel = new Point1[n];
			
			for(int i=0;i<n;i++) {
				customer[i]= new Point1(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			recur(0);
			System.out.println(min);
		}
		
		
	}
	private static void recur(int d) {
		// TODO Auto-generated method stub
		
		if(d==sel.length) {
			int c = Math.abs(company.x-sel[0].x)+Math.abs(company.y-sel[0].y);
			int h = Math.abs(sel[sel.length-1].x-home.x)+Math.abs(sel[sel.length-1].y-home.y);
			int sum=0;
			for(int i=0;i<n-1;i++) {
				sum+=Math.abs(sel[i].x-sel[i+1].x)+Math.abs(sel[i].y-sel[i+1].y);
			}
			min = Math.min(min, c+h+sum);
			return;
			
		}
		
		for(int i=0;i<customer.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				sel[d]=customer[i];
				recur(d+1);
				visited[i]=false;
			}
		}
	}
	

}
class Point1{
	int x,y;
	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
