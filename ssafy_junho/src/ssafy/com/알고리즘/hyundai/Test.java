package ssafy.com.알고리즘.hyundai;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	 static HashMap<Integer,int[]> map;
	    public static void main(String args[]) throws Exception
	    {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int T = Integer.parseInt(br.readLine());
	       
	        for(int tc=0;tc<T;tc++){
	        map = new HashMap<>();
	        map.put(0,new int[]{1,1,1,1,1,1,0});
	        map.put(1,new int[]{0,1,1,0,0,0,0});
	        map.put(2,new int[]{1,1,0,1,1,0,1});
	        map.put(3,new int[]{1,1,1,1,0,0,1});
	        map.put(4,new int[]{0,1,1,0,0,1,1});
	        map.put(5,new int[]{1,0,1,1,0,1,1});
	        map.put(6,new int[]{1,0,1,1,1,1,1});
	        map.put(7,new int[]{1,1,1,0,0,1,0});
	        map.put(8,new int[]{1,1,1,1,1,1,1});
	        map.put(9,new int[]{1,1,1,1,0,1,1});
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            int[] arrA = new int[5];
	            int[] arrB = new int[5];
	            Arrays.fill(arrA,-1);
	            Arrays.fill(arrB,-1);
	            for(int i=0;i<5;i++){
	                arrA[i]=a%10;
	                a/=10;
	                if(a==0) break;
	            }
	            for(int i=0;i<5;i++){
	                arrB[i]=b%10;
	                b/=10;
	                if(b==0) break;
	            }
	            
	            int result=0;
	            for(int i=0;i<5;i++){
	                if(arrA[i]!=arrB[i]){
	                    if(arrA[i]==-1){
	                    result+=sum(arrB[i]);
	                }else if(arrB[i]==-1){
	                    result+=sum(arrA[i]);
	                }else{
	                    result+=diffsum(arrA[i],arrB[i]);
	                }
	                }
	                
	            }
	            System.out.println(result);
	        }
	    }
	    public static int diffsum(int a, int b){
	        int[] arr1 = map.get(a);
	        int[] arr2 = map.get(b);
	        int sum=0;
	        for(int i=0;i<7;i++){
	            if(arr1[i]!=arr2[i]) sum++;
	        }
	        return sum;
	    }
	    public static int sum(int x){
	        int[] arr = map.get(x);

	        int sum=0;

	        for(int i=0;i<7;i++){
	            if(arr[i]==1) sum++;
	            
	            
	        }
	        return sum;
	    }
	
}
