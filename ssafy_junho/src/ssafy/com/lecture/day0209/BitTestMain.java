package ssafy.com.lecture.day0209;

public class BitTestMain {

	public static void main(String[] args) {
		int i=1<<5;
		System.out.println(i);
		System.out.println(Integer.toBinaryString(i));
		
		i=4;
		
		int flag=1<<0;  
		
		System.out.println(i&flag);
		
		//bit배열에서 값 가져오기
		if((i &flag)>0) { 
			System.out.printf("%d 에 %d 번째 자리수의 값은 1입니다",i,1);
		}else System.out.printf("%d 에 %d 번째 자리수의 값은 0입니다\n",i,1);
		
		//bit 배열에 값 넣기
		
		System.out.println(i | 1<<1);
		
		i|= 1<<1;
	}
}
