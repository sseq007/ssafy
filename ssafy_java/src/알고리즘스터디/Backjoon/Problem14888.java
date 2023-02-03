package 알고리즘스터디.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//연산자 끼워넣기
public class Problem14888 {

	static ArrayList<Integer> result = new ArrayList<Integer>();
	static StringTokenizer st;
	static int[] operator;
	static int[] num;
	static int c_val,n;
	
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<4;i++) {
			operator[i]=Integer.parseInt(st.nextToken());
		}
		
		c_val=0;
		calculation(1,c_val);
		
		
		Collections.sort(result);
		
		System.out.println(result.toString());
//		System.out.println(result.get(0));
//		System.out.println(result.get(result.size()-1));
		
	}

	private static void calculation(int x,int c_val) {
		
		if(x==n+1) {
			result.add(c_val);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(operator[i]>=1&&x<=n-1) {
				cal(x,i,c_val);
				operator[i]-=1;
				calculation(x+1, c_val);
				operator[i]+=1;
			}
		}
		
		
	}

	private static void cal(int x, int idx, int c_val) {
		
		
			if(idx==0) {
				c_val += num[x]+num[x+1];
			}
			else if(idx==1) {
				c_val += num[x]-num[x+1];
			}
			else if (idx==2) {
				c_val += num[x]*num[x+1];
			}else {
				int temp = Math.abs(num[x])/num[x+1];
				c_val+=(-1)*temp;
			}
		
		
	}
}
