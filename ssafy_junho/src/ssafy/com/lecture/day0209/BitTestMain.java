package ssafy.com.lecture.day0209;

public class BitTestMain {

	public static void main(String[] args) {
		int i=1<<5;
		System.out.println(i);
		System.out.println(Integer.toBinaryString(i));
		
		i=4;
		
		int flag=1<<0;  
		
		System.out.println(i&flag);
		
		//bit�迭���� �� ��������
		if((i &flag)>0) { 
			System.out.printf("%d �� %d ��° �ڸ����� ���� 1�Դϴ�",i,1);
		}else System.out.printf("%d �� %d ��° �ڸ����� ���� 0�Դϴ�\n",i,1);
		
		//bit �迭�� �� �ֱ�
		
		System.out.println(i | 1<<1);
		
		i|= 1<<1;
	}
}
