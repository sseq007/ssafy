package ssafy_java.workshop06;



public interface IBookManager {
	public void insert(Book b);
	
	public void update(Book b);
	
	public void delete(String isbn);
	
	public void select();
	
//	public Book[] select() {
//		Book[] res = new Book[idx];
//		System.arraycopy(books, 0, res, 0, idx);
//		return res;
//	}
	public Book select(String isbn);
	
	public Magazine[] getMagazines();
		
	public void buy(String isbn,int quantity) throws ISBNNotFoundException;	
	public void sell(String isbn,int quantity) throws ISBNNotFoundException, QuantityException;	
	
}
