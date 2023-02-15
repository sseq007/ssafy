package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

//괄호의 값

/*
 * 올바른 괄호인지 검사
 * (x) 2*x
 * [x] 3*x
 * */
public class Problem2504 {
	static Stack< Character> stack;
	static int result,val;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		System.out.println(arr.length);
		stack = new Stack<Character>();
		
		result=0;
		val=1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='(') {
				stack.push(arr[i]);
				val*=2;
			}
			if(arr[i]=='[') {
				stack.push(arr[i]);
				val*=3;
			}
			if(arr[i]==')') {
				if(stack.peek()!='('||stack.isEmpty()) {
					result=0;
					break;
				}
				if(arr[i-1]=='(') {
					result+=val;
				}
				if(!stack.isEmpty()) {
					stack.pop();
					val/=2;
					
				}
				
			}
			if(arr[i]==']') {
				if(stack.peek()!='['||stack.isEmpty()) {
					result=0;
					break;
				}
				if(arr[i-1]=='[') {
					result+=val;
				}
				if(!stack.isEmpty()) {
					
					stack.pop();
					val/=3;
				}
			}
		}
		System.out.println(result);
//		System.out.println(stack.toString());
	}
	
}
