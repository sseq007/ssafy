package com.homework0203.db;

import  java.sql.*;
public class CreateTable {
	public static void main(String[] args) 	throws Exception{
		//1. Driver 로딩
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. Connection 연결
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
		String query="create table User(id  varchar(20) ,password varchar(20), name  varchar(20), email varchar(100), age int)";
		String query2="create table VipUser(id  varchar(20) ,password varchar(20), name  varchar(20), email varchar(100), age int, grade varchar(20) ,point int)";
		Statement  st=con.createStatement();
		st.execute(query);
		st.execute(query2);
		System.out.println("Table 생성~~");
		st.close();
		con.close();
	}

}

