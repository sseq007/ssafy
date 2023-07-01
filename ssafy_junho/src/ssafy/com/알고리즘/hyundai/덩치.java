package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//BOJ 7568
public class 덩치 {

	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] person = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				person[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int rank =1;
			int weight = person[i][0];
			int height = person[i][1];
			for (int j = 0; j < n; j++) {
				if(i==j) continue;
				if(weight<person[j][0]&&height<person[j][1]) {
					rank++;
				}
			}
			arr.add(rank);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr.get(i)+" ");
		}
		
	}
}
