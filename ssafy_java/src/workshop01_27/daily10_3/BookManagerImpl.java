package workshop01_27.daily10_3;

import java.util.ArrayList;


public class BookManagerImpl implements IBookManager {

	// 3. static 객체 변수를 선언한다.
	static private BookManagerImpl man;

	// 2. static method를 이용하여 객체를 구해온다
	public static BookManagerImpl getInstance() {
		if (man == null) {
			man = new BookManagerImpl();

		}
		return man;
	}

	private ArrayList<Book> list = null;

	// singleton pattern
	// 1. 생성자의 접근지정자를 private 으로 만든다
	private BookManagerImpl() {
		list = new ArrayList<>();
	}

	@Override
	public void insert(Book b) {
		list.add(b);
		
	}

	@Override
	public void delete(String isbn) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				list.remove(i--);
			}
		}
		
	}

	@Override
	public void update(Book b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book select(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Magazine[] getMagazine() {
		// TODO Auto-generated method stub
		return null;
	}

}
