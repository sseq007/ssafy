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
			
			//�����ڶ��
			else if(c=='+'||c=='*'||c=='-'||c=='/') {
				//�ι� pop�ؼ� �����Ŀ� �ٽ� Ǫ���Ѵ�
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
