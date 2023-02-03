package com.ssafy.workshop06;

public class ISBNNotFoundException extends Exception {

	private String isbn; 
	
	public ISBNNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public ISBNNotFoundException(String isbn) {
		System.out.println(isbn+"책은 없습니다");
		this.isbn=isbn;
	}
	public String getIsbn() {
		return isbn;
	}
	
}
