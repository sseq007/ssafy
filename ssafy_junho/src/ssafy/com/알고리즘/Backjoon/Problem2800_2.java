package ssafy.com.알고리즘.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//��ȣ ����
public class Problem2800_2 {

	static boolean[] sel;
	static Stack<Integer> stack;
	static ArrayList<괄호> arr;
	static String data;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		data = br.readLine();

		arr = new ArrayList<괄호>();

		stack = new Stack<Integer>();
		for (int i = 0; i < data.length(); i++) {
			if(data.charAt(i)=='(') stack.push(i);
		}
		for (int i = 0; i < data.length(); i++) {
			if(data.charAt(i)==')') {
				arr.add(new 괄호(stack.pop(), i));
			}
		}
		
		sel = new boolean[arr.size()];
		recur(0);
		System.out.println(sb);
	}

	private static void recur(int idx) {
		if (idx == sel.length) {
			if (allTrue())
				return;
			System.out.println(Arrays.toString(sel));
			
			v= new boolean[data.length()];
			for(int i=0;i<sel.length;i++) {
				if(sel[i]) {
					v[arr.get(i).idx_s]=true;
					v[arr.get(i).idx_e]=true;
				}
			}
			for (int i = 0; i < v.length; i++) {
				if(!v[i]) sb.append(data.charAt(i));
			}
			sb.append("\n");

			return;
		}
		sel[idx] = true;
		recur(idx + 1);
		sel[idx] = false;
		recur(idx + 1);

	}


	private static boolean allTrue() {
		for(int i=0;i<sel.length;i++) {
			if(!sel[i]) return false;
		}
		return true;
	}
}

class 괄호{
	int idx_s;
	int idx_e;
	public 괄호(int idx_s, int idx_e) {
		super();
		this.idx_s = idx_s;
		this.idx_e = idx_e;
	}
	
	
	
}

//		for(int i=0;i<data.length();i++) {
//			if(data.charAt(i)==')') {
//				fo
//				if(!v[])
//					v[j]=true;
////					arr.set(i, '~');
////					��ȣ peek = stack.peek();
////					arr.set(stack.peek().idx, '~');
////					stack.pop();
//					recur(idx+1);
////					stack.push(peek);
//					v[j]=false;
//					
//				
//				
//			}
//		}
//if(sel[i]==true) {
//	for(int j=0;j<data.length();j++) {
//		if(data.charAt(j)==')') {
//			arr.set(j, '~');
//			arr.set(stack.peek().idx, '~');
//			stack.pop();
//			break;
//		}
//	}
//}else {
//	for(int j=0;j<data.length();j++) {
//		if(data.charAt(j)==')') {
//			stack.pop();
//			break;
//		}
//	}
//	
//}