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
		// DOM �ļ� ����
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder builder = factory.newDocumentBuilder();

		// XML ���� �Ľ��ϱ�
		Document document = builder.parse("bml.xml");

		// ��Ʈ ������Ʈ ��ü���� ���
		Element eRoot = document.getDocumentElement();

		// book ������Ʈ ��ü ����
		Element eBook = document.createElement("book");

		// title ������Ʈ ��ü ���� �� ���̱�
		Element eTitle = document.createElement("title");
		Text tTitle = document.createTextNode("��Ž�� �ڳ�");
		eTitle.appendChild(tTitle);

		// author ������Ʈ ��ü ���� �� ���̱�
		Element eAuthor = document.createElement("author");
		Text tAuthor = document.createTextNode("���۰�");
		eAuthor.appendChild(tAuthor);

		// publisher ������Ʈ ��ü ���� �� ���̱�
		Element ePublisher = document.createElement("publisher");
		Text tPublisher = document.createTextNode("�߳��������ǻ�");
		ePublisher.appendChild(tPublisher);

		// price ������Ʈ ��ü ���� ���� �� ���̱�
		Element ePrice = document.createElement("price");
		Text tPrice = document.createTextNode("9000");
		ePrice.appendChild(tPrice);

		// �ڽ� ������Ʈ ��ü�� book ������Ʈ ��ü�� ���̱�
		eBook.appendChild(eTitle);
		eBook.appendChild(eAuthor);
		eBook.appendChild(ePublisher);
		eBook.appendChild(ePrice);

		// �Ӽ� ��ü�� book ������Ʈ ��ü�� ���̱�
		eBook.setAttribute("kind", "��ȭå");

		// book ������Ʈ ��ü�� ��Ʈ ������Ʈ ��ü�� ���̱�
		eRoot.appendChild(eBook);

		System.out.println("�߰� ����");
		
		
		
		TransformerFactory factory1 = TransformerFactory.newInstance();
		Transformer tf = factory1.newTransformer();
		tf.setOutputProperty("encoding", "euc-kr");
		tf.setOutputProperty("indent", "yes");
		DOMSource src = new DOMSource(document);
		//StreamResult result1 = new StreamResult(System.out);
		StreamResult result = new StreamResult(
				new FileOutputStream("book.xml"));
		tf.transform(src, result);
		System.out.println("���ο� xml ���� ���� �Ϸ�");
		
		
	}

}
