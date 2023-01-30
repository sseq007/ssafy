package 알고리즘스터디.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//오리
public class Problem12933 {

	static char[] duck_sound = {'q','u','a','c','k'};
	static Stack<Character> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String sound = br.readLine();
		stack = new Stack<>();
		int idx=0;
		int result=0;
		for(int i=0;i<sound.length();i++) {
			for(int j=0;j<duck_sound.length;j++) {
				if(sound.charAt(i)==duck_sound[j]&&idx==j) {
					stack.push(duck_sound[j]);
					idx+=1;
				}
			}
			if (check()) {
				result+=1;
				idx=0;
				stack.clear();
			}
			
		}
		if(result==0) result=-1;
		System.out.println(result);
		
		
		
	}

	public static boolean check() {
		
		int count=0;
		for(int j=0;j<duck_sound.length;j++) {
			if(stack.contains(duck_sound[j])) {
				count+=1;
			}
		}
		if(count==5) {
			return true;
		}
		else return false;
	
	}
}
