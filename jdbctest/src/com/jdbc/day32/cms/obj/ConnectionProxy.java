package com.jdbc.day32.cms.obj;
import  java.sql.*;

public class  ConnectionProxy{
	
	public static  Connection  getConnection() throws SQLException{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
			return con;
		}catch(ClassNotFoundException e){
			System.out.println("JDBC Driver 로딩에러.");
			throw new SQLException();
		}
	}

}//end class
