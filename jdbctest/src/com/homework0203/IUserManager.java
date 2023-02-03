package com.homework0203;


public interface IUserManager {

	void add(User user);

	void getUsers();

	void searchByName(String name) throws NameNotFoundException;

	void getAgeAvg();

	
}
