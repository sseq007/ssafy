package com.homework0203;

import java.util.Arrays;

import com.homework0203.db.UserDAO;
import com.homework0203.db.UserService;


public class UserTest {

	public static void main(String[] args) throws NameNotFoundException {
		
//		UserDAO udao = new UserDAO();
//		
//		udao.insertUser("1", "1", "junho", "sseq00@naver.com", 25);
//		udao.insertUser("2", "2", "junho2", "sseq00@naver.com", 26);
//		udao.insertUser("3", "3", "junho3", "sseq00@naver.com", 27);
//		udao.viewUser();
//		udao.viewUsername("junho2");
		
		User user1 = new User();
		user1.setId("user1");
		user1.setPassword("user1");
		user1.setName("김싸피");
		user1.setEmail("ssafy1@ssafy.com");
		user1.setAge(27);

		User user2 = new User("user2", "user2", "박싸피", "ssafy2@ssafy.com", 28);
		VipUser vuser = new VipUser("vip1", "vip1", "김싸피", "ssafy3@ssafy.com", 29, "Gold", 300);
		
//		
		IUserManager um = UserService.getInstacne();
//		
//		
		um.add(user1);
		um.add(user2);
		um.add(vuser);

		
		try {
			um.searchByName("김싸피");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		
		um.getUsers();
		um.getAgeAvg();
		
		
		
//		try {
//			System.out.println(Arrays.toString(um.searchByName("김")));
//		} catch (NameNotFoundException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Arrays.toString(um.getUsers()));
//		System.out.println(um.getAgeAvg());


	}

}
