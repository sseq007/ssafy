package 알고리즘스터디.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//크로아티아 알파벳
public class Problem2941 {

	static String[] code= {"c=","c-","dz=","d-","lj","nj","s=","z="};
	static int count;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String data = br.readLine();
		count=0;
		int idx=0;
		while(true) {
			if(idx==data.length()) {
				break;
			}
			String alp = data.substring(idx, idx+2);
			
			if(check(alp)) {
				count+=1;
				idx+=2;
			}
			else {
				count+=1;
				idx+=1;
			}
		}
		System.out.println(count);
	}
	private static boolean check(String alp) {
		for(int i=0;i<code.length;i++) {
			if(alp.equals(code[i])) {
				return true;
				
			}
		}
		return false;
	}
}
