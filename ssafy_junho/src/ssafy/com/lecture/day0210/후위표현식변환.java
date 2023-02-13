package ssafy.com.lecture.day0210;

import java.util.Iterator;
import java.util.Stack;

public class 후위표현식변환 {

	/*
	 * 1. 숫자일 경우 그냥 출력.
	 * 2. + 나 *가 나오면 스택을 확인한다.
	 * 		2-1. 스택이 비어있으면 push
	 * 		2-2	 스택이 비어있지 않으면 * 가 + 보다 연산순위가 높다
	 * 			2-2-1. 읽어들인 연산자가 스택의 탑보다 우선순위가 높으면 그냥 push
	 * 			2-2-2. 읽어들인 연산자가 스택의 탑보다 같거나,낮은경우 탑을 pop하고 출력
	 * 				     스택의 push
	 * 			2
	 * 
	 * */
	public static void main(String[] args) {
		String expr = "2+3*4*5+6";
		//234*5*+6+
		
		Stack<Character> s = new Stack<Character>();
		StringBuffer sb = new StringBuffer();
		
		//expr을 한자씩 읽습니다
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			//숫자면 출력
			if(Character.isDigit(c)) sb.append(c);
			else if(c=='+') {
				//비어있는지 확인하고 
				while(!s.isEmpty()) {
					sb.append(s.pop());
				}
				s.push(c);
			}else if(c=='*') {
				
				while(!s.isEmpty()&&s.peek()!='+') {
					sb.append(s.pop());
				}
				s.push(c);
			}
		}
		while(!s.isEmpty()) {
			sb.append(s.pop());
		}
		System.out.println(sb);
		
	}
}
