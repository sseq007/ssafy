package ssafy.com.lecture.day0215.DebugExam.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ssafy.com.lecture.day0215.DebugExam.vo.Person;

/*
 * 
 * singleton 구현
 * 
 * 
 * */
public class PersonManager implements Manager ,Serializable {
	private static Manager man;
	private List<Person> list = new ArrayList<Person>();
	private PersonManager() {
		
	}
	
	public static Manager getInstance() {
		if(man==null) {
			man = new PersonManager();
			return man;
		}
		return man;
	}

	@Override
	public void add(Person p) {
		list.add(p);
		
	}

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		return list;
	}
}
