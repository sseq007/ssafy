package ssafy.com.lecture.day0210;

import java.util.Iterator;
import java.util.Stack;

public class 후위표현식변환 {

	/*
	 * 1. ������ ��� �׳� ���.
	 * 2. + �� *�� ������ ������ Ȯ���Ѵ�.
	 * 		2-1. ������ ��������� push
	 * 		2-2	 ������ ������� ������ * �� + ���� ��������� ����
	 * 			2-2-1. �о���� �����ڰ� ������ ž���� �켱������ ������ �׳� push
	 * 			2-2-2. �о���� �����ڰ� ������ ž���� ���ų�,������� ž�� pop�ϰ� ���
	 * 				     ������ push
	 * 			2
	 * 
	 * */
	public static void main(String[] args) {
		String expr = "2+3*4*5+6";
		//234*5*+6+
		
		Stack<Character> s = new Stack<Character>();
		StringBuffer sb = new StringBuffer();
		
		//expr�� ���ھ� �н��ϴ�
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			//���ڸ� ���
			if(Character.isDigit(c)) sb.append(c);
			else if(c=='+') {
				//����ִ��� Ȯ���ϰ� 
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
