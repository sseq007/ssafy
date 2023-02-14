package ssafy.com.lecture.day0206.problem.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀함수가뭔가요 {
	static int n;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		response(0,"");
		
		
		System.out.println("��� �亯�Ͽ���.");
		
		
	}

	private static void response(int idx,String str) {
		
		
		if(idx==n) {
			System.out.println(str+"\"����Լ��� ������?\"");
			System.out.println(str+"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			
			return;
		}
		
		
		System.out.println(str+"\"����Լ��� ������?\"");
		System.out.println(str+"\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		System.out.println(str+"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		
		System.out.println(str+"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
		
		response(idx+1, str+="____");
		
		System.out.println(str+"��� �亯�Ͽ���.");
		
	}
}
