package ssafy.com.lecture.day0215.DebugExam.main;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;

import ssafy.com.lecture.day0215.DebugExam.dao.Manager;
import ssafy.com.lecture.day0215.DebugExam.dao.PersonManager;
import ssafy.com.lecture.day0215.DebugExam.vo.Person;

public class Dispatcher {

	public static void main(String[] args) throws FileNotFoundException, Exception {
		Manager man = PersonManager.getInstance();
		man.add(new Person("홍길동",21));
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("test.ob")));
		//나이순 정렬
		Collections.sort(man.list(),new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return 0;
			}
			
		});
		oos.writeObject(man);
	}
}
