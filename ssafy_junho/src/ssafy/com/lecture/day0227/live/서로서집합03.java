package ssafy.com.lecture.day0227.live;

/*
 * 배열을 이용하여 서솔소집합을 구성할 수 있습니다.
 * 
 * 
 * */
public class 서로서집합03 {

	static int n =10;
	
	public static void main(String[] args) {
		int[] set = new int[n];
		
		//make - set
		for (int i = 0; i < set.length; i++) {
			set[i] = i;
		}
		//union - find
//		for (int i = 0; i < set.length; i++) {
//			union(i,2,set);
//		}
		union(3,2,set);
	}

	private static void union(int org, int rep,int[] set) {
		for (int i = 0; i < set.length; i++) {
			if(set[i]==org) set[i]=rep;
		}
		
	}
}
