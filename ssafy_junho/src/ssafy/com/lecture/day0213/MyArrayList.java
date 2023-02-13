package ssafy.com.lecture.day0213;

import java.util.Arrays;

import ssafy.com.lecture.day0213.MyLinkedList.Node;

public class MyArrayList implements IList {

	private Object[] list;
	private int size,N=10;
	
	public MyArrayList() {
		
		list = new Object[N];
	}
	public MyArrayList(int n) {
		this.N=n;
		list = new Object[N];
	}
	
	@Override
	public void add(int index, Object obj) {
		for (int i = size-1; i >= index; i--) {
			list[i+1] = list[i];
		}
		list[index] = obj;
		size++;

	}																							//집 가고 싶다다다다다다다ㅏ

	@Override
	public Object get(int index) {
		
		
		return list[index];
	}

	@Override
	public Object remove(int index) {
		Object obj = list[index];
		for (int i = index; i < size-1; i++) {
			list[i]=list[i+1];
		}
		size--;
		
		return obj;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node tmp = head;
		while(tmp!=null) {
			sb.append(tmp.obj+",");
			
		}
		return super.toString();
	}
	
	

}
