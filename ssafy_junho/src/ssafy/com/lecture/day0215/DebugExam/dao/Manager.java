package ssafy.com.lecture.day0215.DebugExam.dao;

import java.util.List;

import ssafy.com.lecture.day0215.DebugExam.vo.Person;

public interface Manager {

	void add(Person p);
	List<Person> list();
}
