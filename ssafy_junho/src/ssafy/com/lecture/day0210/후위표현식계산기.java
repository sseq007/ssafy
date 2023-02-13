package ssafy.com.lecture.day0210;

import java.util.Iterator;
import java.util.Stack;

public class 후위표현식계산기 {

	public static void main(String[] args) {
		String expr = "234*5*+6+";
		//234*5*+6+
		
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			
			if(Character.isDigit(c)) s.push(c-'0');
			
			//연산자라면
			else if(c=='+'||c=='*'||c=='-'||c=='/') {
				//두번 pop해서 연산후에 다시 푸쉬한다
				int n2 = s.pop();
				int n1 = s.pop();
				
				switch(c) {
				case '+':
					s.push(n1+n2);
					break;
				case '-':
					s.push(n1-n2);
					break;
				case '*':
					s.push(n1*n2);

					break;
				case '/':
					s.push(n1/n2);
					break;
				}
				
				
			}
		}
		System.out.println(s.pop());
		
	}
}
