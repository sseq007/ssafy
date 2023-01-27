package workshop01_27;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOTest5 {

	
	public static void main(String[] args) {
		
		
		ArrayList<Person> list = null;
		try (ObjectInputStream oos = new ObjectInputStream(new BufferedInputStream(new FileInputStream("listobject")))) {
//			Person p = null;
//			while((p = (Person) oos.readObject())!=null) {
//				list.add(p);
//			}
			
			list = (ArrayList<Person>)oos.readObject();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
	}
}
