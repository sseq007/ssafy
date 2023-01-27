package workshop01_27;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class AA implements Serializable{
	int bb;
}

class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	/*transient*/ String name;
	int age;
	AA a;
	
	public Person(String name, int age) {
		super();
		a= new AA();
		a.bb =10;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
public class IOTest02 {

	public static void main(String[] args) {
		
		Person p = new Person("홍길동",21);
		
		try {
			FileOutputStream fos = new FileOutputStream("test3");
			ObjectOutputStream oos  = new ObjectOutputStream(fos);
			
			oos.writeObject(p);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
