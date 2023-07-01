package ssafy.com.알고리즘.a형막트.찐막;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지하철노선 {

	static int n;
	static int[] nums;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			n = Integer.parseInt(br.readLine());
			nums = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				nums[i]=Integer.parseInt(st.nextToken());
			}
			
			int max_sum = Integer.MIN_VALUE;
			
			for (int a = 0; a < n-6; a++) {
				for (int b = a+2; b < n-4; b++) {
					for (int c = b+2; c < n-2; c++) {
						for (int d = c+2; d < n; d++) {
							if(d+1-n==a) continue;
							int total = (int) Math.pow((nums[a]+nums[b]), 2)+(int) Math.pow((nums[c]+nums[d]), 2);
							max_sum= Math.max(total, max_sum);
							total = (int) Math.pow((nums[a]+nums[d]), 2)+(int) Math.pow((nums[c]+nums[b]), 2);
							max_sum= Math.max(total, max_sum);
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+max_sum);
			
			
		}
		
	}
}
