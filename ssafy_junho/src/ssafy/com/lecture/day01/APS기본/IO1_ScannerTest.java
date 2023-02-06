package ssafy.com.lecture.day01.APS기본;

import java.util.Scanner;

/**
 * @author THKim
 */
/*
9
援щ젅�엲
 */
public class IO1_ScannerTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("紐� 湲�? : ");
		System.out.println("==> SSAFY : "+sc.nextInt());
		
		System.out.print("�슦由� 湲곗닔瑜� �굹���궡�뒗 �븳留덈뵒 ? : ");
		System.out.print("==> �븳留덈뵒 :"+sc.next()+"!");
		
//		System.out.print("==> �븳留덈뵒 :"+sc.nextLine()+"!");
//		System.out.print("==> �븳留덈뵒 :"+sc.nextLine()+"!");
		
		sc.close();
	}
}
