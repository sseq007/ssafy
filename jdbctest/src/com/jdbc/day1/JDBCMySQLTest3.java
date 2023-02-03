package com.jdbc.day1;
import  java.sql.*;
// 예외처리 
class  JDBCMySQLTest3{
	public static void main(String[] args) 	throws Exception{
		Connection con= null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//1. Driver 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Connection 연결
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hr?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","exam","exam");
			
			//3. Query, 
			//String query="Select * from Employees";
			String query="Select * from Departments";
			//String query="Select * from Jobs";
			//String query="Select * from Locations";
			st=con.createStatement();
			//4. Query Execute
			rs=st.executeQuery(query);
			//5. resultSet 
			while(	rs.next()  ){
				String num=rs.getString(1);
			//	String name=rs.getString("FIRST_NAME");
				String name=rs.getString(2);
				System.out.println(num+"\t"+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			//6.close
			if(rs!=null)try{rs.close();}catch(Exception  e1){}
			if(st!=null)try{st.close();}catch(Exception  e1){}
			if(con!=null)try{con.close();}catch(Exception  e1){}
		}
	}
}
