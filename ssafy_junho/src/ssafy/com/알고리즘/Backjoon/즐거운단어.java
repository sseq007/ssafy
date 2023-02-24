package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 즐거운단어 : 모음(A,E,I,O,U)이 연속해서 3번, 자음이 연속해서 3번 X, L을 반드시 포함
 * 
 * */
public class 즐거운단어 {
	static char[] gather= {'A','E','I','O','U'};
	static char[] alp;
	static ArrayList<Integer> blank;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		alp =  br.readLine().toCharArray();
		
		for (int i = 0; i < alp.length; i++) {
			if(alp[i]=='_') {
				blank.add(i);
			}
		}
		
		recur(0);
		
	}

	private static void recur(int idx) {
		
		if(idx == blank.size()) {
			return;
		}
		
		
		for(int i=0;i<blank.size();i++) {
			
		}
	}
}
