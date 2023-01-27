package workshop01_27.daily10_3;


/**
 * 
 * @author SSAFY
 * @version=0.1
 * 
 * 북관리 매니저
 * **/
public class BookArrayManager implements IBookManager {

	private Book[] books;
	private Book[] u_books;
	private int idx = 0;
	private int MAX=5;
	public BookArrayManager() {
		books=new Book[MAX];
	}
	
	
	public void insert(Book b) {
		if (idx ==MAX) {
			MAX*=2;
			u_books = new Book[MAX];
			
			for (int i = 0; i < books.length; i++) {
				u_books[i]=books[i];
			}
			//System.arraycopy(books, 0, u_books, 0, books.length);
			books=u_books;
		} 
			books[idx] = b;
			idx++;
		
	}
	
	public void update(Book b) {
		for (int i = 0; i < idx; i++) {
			if(books[i].getIsbn().equals(b.getIsbn())){
				books[i]=b;
			}
		}
		
	}
	
	public void delete(String isbn) {
		for (int i = 0; i < idx; i++) {
			if(books[i].getIsbn().equals(isbn)){
				for(;i<idx;i++)
					books[i]=books[i+1];
//				books[i]=books[idx-1];
//				idx--
//				return;
			}
			
		}
		idx--;
	}
	
	public void select() {
		
		for (int i = 0; i < idx; i++) {
			System.out.println(books[i]);
		}
		
	}
	
//	public Book[] select() {
//		Book[] res = new Book[idx];
//		System.arraycopy(books, 0, res, 0, idx);
//		return res;
//	}
	public Book select(String isbn) {
		for (int i = 0; i < idx; i++) {
			if(books[i].getIsbn().equals(isbn)){
				return books[i];
			}
		}
		return null;
	}


	@Override
	public Magazine[] getMagazine() {
		int cnt=0;
		int cur=0;
		for (int i = 0; i < idx; i++) {
			if(books[i] instanceof Magazine) {
				cnt++;
			}
			
		}
		Magazine[] ms = new Magazine[cnt];
		for (int i = 0; i < idx; i++) {
			if(books[i] instanceof Magazine) {
				ms[cur++]=(Magazine)books[i];
			}
			
		}
		return ms;
	}


	
}
