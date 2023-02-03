package com.ssafy.c_inheritance;

class person{
	String name="홍길동";
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
public class StringTest {

	public static void main(String[] args) {
	
		//해쉬값이 나오기떄문에 toString()을 override해야한다
		System.out.println(new person().toString());
		String str1 = new String("ssafy");
		String str2 = new String("ssafy");
		
		if(str1 == str2) {
			System.out.println("같다");
		}
		else {
			System.out.println("다르다");
		}
		if(str1.equals(str2)) {
			System.out.println("같다");
		}
		else {
			System.out.println("다르다");
		}
		
		
		
		//literal pool에서 ssafy를 찾는다 둘의 주소값은 같다
		String str3 = "ssafy";
		String str4 = "ssafy";
		
		//배열은 resize 되지 않아 문자열 크기의 배열을 만든후 각각 값을 복사하여 만든다
		
		str3 = str3+"ssafy";
		if(str3==str4) {
			System.out.println("같다");
		}
		else {
			System.out.println("다르다");
		}

		//null를 문자열 처리한다
		String str5=null;
		str5 = str5+"ssafy!!";
		
		
		System.out.println(str1);
		System.out.println(str1.toString());
		
		
	}

	

}
