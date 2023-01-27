package workshop01_27;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class IOTest03 {

	
	public static void main(String[] args) {
		
		try {
			
			ObjectInputStream ols = new ObjectInputStream(new FileInputStream("test3"));
			Person a = (Person)ols.readObject();
			System.out.println(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
