package edu.jaen.java.xml.basic;

import java.io.FileOutputStream;
import java.io.FileReader;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.*;

public class DOMAddElementTest {

	public static void main(String[] args) throws Exception {
		// DOM 파서 생성
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder builder = factory.newDocumentBuilder();

		// XML 문서 파싱하기
		Document document = builder.parse("bml.xml");

		// 루트 엘리먼트 객체참조 얻기
		Element eRoot = document.getDocumentElement();

		// book 엘리먼트 객체 생성
		Element eBook = document.createElement("book");

		// title 엘리먼트 객체 생성 및 붙이기
		Element eTitle = document.createElement("title");
		Text tTitle = document.createTextNode("명탐정 코난");
		eTitle.appendChild(tTitle);

		// author 엘리먼트 객체 생성 및 붙이기
		Element eAuthor = document.createElement("author");
		Text tAuthor = document.createTextNode("나작가");
		eAuthor.appendChild(tAuthor);

		// publisher 엘리먼트 객체 생성 및 붙이기
		Element ePublisher = document.createElement("publisher");
		Text tPublisher = document.createTextNode("잘나간다출판사");
		ePublisher.appendChild(tPublisher);

		// price 엘리먼트 객체 생성 생성 및 붙이기
		Element ePrice = document.createElement("price");
		Text tPrice = document.createTextNode("9000");
		ePrice.appendChild(tPrice);

		// 자식 엘리먼트 객체를 book 엘리먼트 객체에 붙이기
		eBook.appendChild(eTitle);
		eBook.appendChild(eAuthor);
		eBook.appendChild(ePublisher);
		eBook.appendChild(ePrice);

		// 속성 객체를 book 엘리먼트 객체에 붙이기
		eBook.setAttribute("kind", "만화책");

		// book 엘리먼트 객체를 루트 엘리먼트 객체에 붙이기
		eRoot.appendChild(eBook);

		System.out.println("추가 성공");
		
		
		
		TransformerFactory factory1 = TransformerFactory.newInstance();
		Transformer tf = factory1.newTransformer();
		tf.setOutputProperty("encoding", "euc-kr");
		tf.setOutputProperty("indent", "yes");
		DOMSource src = new DOMSource(document);
		//StreamResult result1 = new StreamResult(System.out);
		StreamResult result = new StreamResult(
				new FileOutputStream("book.xml"));
		tf.transform(src, result);
		System.out.println("새로운 xml 파일 생성 완료");
		
		
	}

}
