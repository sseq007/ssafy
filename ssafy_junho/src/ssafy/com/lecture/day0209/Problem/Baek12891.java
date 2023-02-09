package ssafy.com.lecture.day0209.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//DNA 비밀번호
/*
 * {A C G T}
 *
 * 
 * 
 * */
public class Baek12891 {

	static int s,p;
	static char[] data;
	static StringTokenizer st;
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		data= new char[s];
		int[] dna_n= new int[4];
		
		String dna = br.readLine();
		
		for(int i=0;i<s;i++) {
			data[i]=dna.charAt(i);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			dna_n[i]=Integer.parseInt(st.nextToken());
		}
		int n = s-p+1;
		for(int i=0;i<n;i++) {
			String str = dna.substring(i, i+p);
			System.out.println(str);
			check(str,dna_n);
		}
		
		
		
		System.out.println(cnt);
	}
	private static void check(String str,int[] dna_n) {
		char[] arr = str.toCharArray();
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(dna_n));
			if(!check(arr[i],dna_n)) {
				break;
			}
			
			cnt+=1;
		}
		
		
		
		
	}
	private static boolean check(char c,int[] dna_n) {
		switch (c) {
		case 'A':
			if(dna_n[0]>0) dna_n[0]--;
			else return false;
			
		case 'C':
			if(dna_n[1]>0) dna_n[1]--;
			else return false;
			
		case 'G':
			if(dna_n[2]>0) dna_n[2]--;
			else return false;
			
		case 'T':
			if(dna_n[3]>0) dna_n[3]--;
			else return false;
			
		}
		return true;
	}
		
}

		
		
	
	
//private static void recur(int idx) {
//	if(idx==sel.length) {
//		
//		dna_n = Arrays.copyOf(temp_arr, 4);
//		System.out.println(Arrays.toString(sel));
//		check(sel);
//		System.out.println(Arrays.toString(dna_n));
//		return;
//	}
//	
//	
//	for(int i=0;i<data.length;i++) {
//		if(!v[i]) {
//			v[i]=true;
//			sel[idx]=data[i];
//			recur(idx+1);
//			v[i]=false;
//		}
//	}

