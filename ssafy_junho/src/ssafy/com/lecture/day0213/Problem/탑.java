package ssafy.com.lecture.day0213.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ž {

	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			int val1 = Integer.parseInt(st.nextToken());
			while(true) {
				
				if(!stack1.isEmpty()) {
					
					int val2 = stack1.peek();
					if(val1<val2) {
						System.out.print(stack2.peek()+" ");
						stack1.push(val1);
						stack2.push(i);
						
						
						break;
					}
					else {
						stack1.pop();
						stack2.pop();
					}
				}
				
				
				else {
					System.out.print("0 ");
					stack1.push(val1);
					stack2.push(i);
					break;
				}
				
			}
			
		}
				
		
		
		
		
		
		
	}
}



