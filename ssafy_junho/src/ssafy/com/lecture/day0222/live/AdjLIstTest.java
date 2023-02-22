package ssafy.com.lecture.day0222.live;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjLIstTest {

	static ArrayList<Integer>[] adjList;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		adjList = new ArrayList[v] ; // head가 모두 null인 상태
		
		
		int from,to;
		for(int i=0;i<v;i++) {
			adjList[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<e;i++) {
			from = sc.nextInt();
			to = sc.nextInt();			
			// 무향 그래프
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		print();
		
	}
	static void print() {
		for (ArrayList<Integer> list : adjList) {
			System.out.println(list);
		}
		
	}
}
