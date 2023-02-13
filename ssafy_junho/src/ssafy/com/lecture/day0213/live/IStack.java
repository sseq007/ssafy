package ssafy.com.lecture.day0213.live;

public interface IStack<T> {

	void push(T e);
	T pop();
	T peek();
	boolean isEmpty();
	int size();
	
}
