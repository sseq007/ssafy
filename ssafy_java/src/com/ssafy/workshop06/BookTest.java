package com.ssafy.workshop06;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
//	public static void main(String[] args) {
//		books[0] = new Book("00001","java","ssafy","ssafy",1000,"자바를 공부하자");
//		books[1] = new Book("00002","java2","ssafy","ssafy",1000,"자바를 공부하자2");
//		books[2] = new Book("00003","java3","ssafy","ssafy",1000,"자바를 공부하자3");
//		books[3] = new Book("00004","java4","ssafy","ssafy",1000,"자바를 공부하자4");
//		books[4] = new Book("00005","java5","ssafy","ssafy",1000,"자바를 공부하자5");
//		books[5] =(Book) new Magazine("00002", "c++", "ssafy", "ssafy", 15000, "월간 C++", 2023, 1);
//		

//		for (int i = 0; i < books.length; i++) {
//			System.out.println(books[i].toString());

//		Magazine m = new Magazine("00002", "c++", "ssafy", "ssafy", 15000, "월간 C++", 2023, 1);
//		System.out.println(m);
//		
//		Book m =(Book) new Magazine("00002", "c++", "ssafy", "ssafy", 15000, "월간 C++", 2023, 1);

		//매니저가 change 될 따마다 코드를 따로 적어야한다 이떄 framework에서 DI을 통해 해결가능
		IBookManager man = new BookManagerImpl();
		Scanner sc = new Scanner(System.in);
		int state=0;
		
		while (true) {
			
			if(state==1) {
				break;
			}
			System.out.println("목차를 선택하시오");
			
			int id = 0;
			System.out.println("0:종료 1:입력 2:수정 3:삭제 4:리스트 5:조회 6:구매 7:판매");
			System.out.println("***********************************************");
			
			id= sc.nextInt();
			switch (id) {
			case 0: {
				System.out.println("프로그램이 종료되었습니다!");
				state=1;
				break;
			}
			case 1: {
				System.out.println("isbn을 입력하시오");
				String isbn = sc.next();
				System.out.println("title을 입력하시오");
				String title = sc.next();
				System.out.println("author을 입력하시오");
				String author = sc.next();
				System.out.println("publisher을 입력하시오");
				String publisher = sc.next();
				System.out.println("price을 입력하시오");
				int price = sc.nextInt();
				System.out.println("desc을 입력하시오");
				String desc = sc.next();
				System.out.println("quantity을 입력하시오");
				int quantity = sc.nextInt();
				
				man.insert(new Book(isbn, title, author, publisher, price, desc, quantity));
				
				break;
			}
			case 2: {
				System.out.println("isbn을 입력하시오");
				String isbn = sc.next();
				System.out.println("title을 입력하시오");
				String title = sc.next();
				System.out.println("author을 입력하시오");
				String author = sc.next();
				System.out.println("publisher을 입력하시오");
				String publisher = sc.next();
				System.out.println("price을 입력하시오");
				int price = sc.nextInt();
				System.out.println("desc을 입력하시오");
				String desc = sc.next();
				System.out.println("quantity을 입력하시오");
				int quantity = sc.nextInt();
				
				
				man.update(new Book(isbn, title, author, publisher, price, desc,quantity));
				break;
			}
			case 3:{
				System.out.println("isbn을 입력하시오");
				String isbn = sc.next();
				man.delete(isbn);
				break;
			}
			case 4: {
				
				man.select();
				break;

			}
			case 5: {
				System.out.println("isbn을 입력하시오");
				String isbn3 = sc.next();
				System.out.println(man.select(isbn3));
				
				break;
			}
			
			case 6: {
				System.out.println("isbn을 입력하시오");
				String isbn3 = sc.next();
				System.out.println("수량을 입력하세요");
				int quantity=sc.nextInt();
				try {
					man.buy(isbn3, quantity);
				} catch (ISBNNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			}

			}
		}
	}
}
