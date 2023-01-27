package workshop01_27.daily10_3;


public interface IBookManager {

	public void insert(Book b) ;
	public void delete(String isbn);
	public void update(Book b) ;
	public void select() ;
	public Book select(String isbn) ;
	public Magazine[] getMagazine() ;
}
