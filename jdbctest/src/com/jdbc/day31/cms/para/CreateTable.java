package com.jdbc.day31.cms.para;
import  java.sql.*;

class  CreateTable{
	public static void main(String[] args) 	throws Exception{
		//1. Driver 로딩
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. Connection 연결
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
		String query="create table customer(num  int  primary key, name  varchar(20), address  varchar(200))";
		Statement  st=con.createStatement();
		st.execute(query);
		System.out.println("Table 생성~~");
		st.close();
		con.close();
	}
}
