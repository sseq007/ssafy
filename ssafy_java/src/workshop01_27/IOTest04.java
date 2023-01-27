package workshop01_27;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOTest04 {

	
	public static void main(String[] args) {
		
		ArrayList<Person> list = new ArrayList<>();
		
		list.add(new Person("홍길동",21));
		list.add(new Person("홍길동",22));
		
		list.add(new Person("홍길동",23));
		list.add(new Person("홍길동",24));
		list.add(new Person("홍길동",25));
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("listobject")))) {
//			for (Person person : list) {
//				oos.writeObject(person);
//			}
			
			oos.writeObject(list);
			System.out.println("파일 생성 완료");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
