package ssafy.com.lecture.day0214.live;

public class CompleteBinaryTest {

	public static void main(String[] args) {
		
		int size = 9;
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree<Character>(size);
		
		for(int i=0;i<size;++i) {
			tree.add((char)(65+i));
		}
	}
}
