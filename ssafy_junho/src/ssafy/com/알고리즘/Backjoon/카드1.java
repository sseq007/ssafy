package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 카드1 {

	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <=n; i++) {
			q.add(i);
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(q.size()!=1) {
			//카드 버리기
			int left = q.poll();
			arr.add(left);
			int card = q.poll();
			q.add(card);
		}
		arr.add(q.poll());
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i)+" ");
		}
	}
}
