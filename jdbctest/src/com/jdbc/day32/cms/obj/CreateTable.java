package com.jdbc.day32.cms.obj;
import  java.sql.*;

class  CreateTable{
	public static void main(String[] args) 	throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
		
		String dropSql="drop table customer";
		Statement  dropSt=con.createStatement();
		dropSt.execute(dropSql);
		
		String query="create table customer(num  number(4)  primary key, name  varchar2(20), address  varchar2(200))";
		Statement  st=con.createStatement();
		st.execute(query);
		System.out.println("Table ���� �Ϸ�~~");
		
		dropSt.close();
		st.close();
		con.close();
	}
}
