package com.homework0203.db;

import com.homework0203.IUserManager;
import com.homework0203.NameNotFoundException;
import com.homework0203.User;
import com.homework0203.VipUser;

public class UserService implements IUserManager {

	private static UserService um = new UserService();
	
	private UserService() {};
	
	public static UserService getInstacne() {
		return um;
	}
	
	private UserDAO udao = new UserDAO();
	@Override
	public void add(User user) {
		if((user instanceof VipUser) ) {
			udao.insertUser(user.getId(), user.getPassword(), user.getName(), user.getEmail(), user.getAge());
			udao.insertVipUser(user.getId(), user.getPassword(), user.getName(), user.getEmail(), user.getAge(),((VipUser) user).getGrade(),((VipUser) user).getPoint());
		}
		else {
			udao.insertUser(user.getId(), user.getPassword(), user.getName(), user.getEmail(), user.getAge());
		}
	}


	@Override
	public void getUsers() {

		udao.viewUser();
	}


	@Override
	public void searchByName(String name) throws NameNotFoundException {
		// TODO Auto-generated method stub
		udao.viewUsername(name);
	}

	@Override
	public void getAgeAvg() {
		
		udao.searchAgeAvg();
	}


	



	
	
}
