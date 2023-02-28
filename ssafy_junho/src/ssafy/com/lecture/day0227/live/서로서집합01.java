package ssafy.com.lecture.day0227.live;

/*
 * 트리를 서로서개념을 구현
 * 0 1 2 3 4 5 6 7 8 9 
 * 
 * rank(tree의 높이) 사용
 * a,b를 합칠떄 b를 무조건 밑에다 넣는다고 하면 
 * a
 * b
 * 가 되고 c d e f 까지 밑으로 넣는다고 하면
 * 
 * a
 * b
 * c
 * d
 * e
 * f
 * 의 트리가 된다. 그래서 대표자를 찾을떄 여러번의 재귀가 일어나야 한다
 * 그래서 두 트리집합을 합칠떄 이왕이면 높이가 높은 트리 밑으로 낮은트리를 넣으면
 * 높이가 낮을 트리집합을 만들수 있다
 * o(logN)
 * 
 * */
public class 서로서집합01 {

	static int n = 8;
	static int[] height;
	public static void main(String[] args) {

		int[] parent = new int[n];
		height = new int[n];
		
		//makeSet
		for (int i = 0; i < parent.length; i++) {
			parent[i]=i;
		}
		
		//Union - find
		union(0,2,parent);		
		union(1,2,parent);		
		union(3,4,parent);		
		union(6,4,parent);		
		union(7,4,parent);		
		union(4,5,parent);		
		union(3,1,parent);		
	}

	private static void union(int orgA, int orgB, int[] set) {

		int a = find_rep(orgA,set);
		int b = find_rep(orgB,set);
		
		if(a!=b) {
			//두조직의 대표자가 다르면 다른 조직이므로 합친다.
			// idx : 조직의 번호
			// value: 대표자 번호
			//set[a] = set[b];
			// 높이를 이용해서 union 해보자
			if(height[b]>height[a]) {
				//b ㅈ직이 a 보다 높이가 높다면 a조직이 b조직 밑으로 들어간다
				set[a] = set[b];
			}else {
				set[b] = set[a];
				if(height[a]==height[b]) {
					height[b]++;
				}

			}
		}
		
	}

	private static int find_rep(int org, int[] set) {
		if(set[org] == org) return org;
		//path compression
		else 
			//return find_rep(set[org],set);
			
			return set[org]= find_rep(set[org],set);
		
	}
}
