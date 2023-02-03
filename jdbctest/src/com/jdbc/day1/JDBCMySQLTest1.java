package com.jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCMySQLTest1 {

	public static void main(String[] args)throws Exception {
		// 1. Driver Loading
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. Connection 
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
		// 3. Statement Create
		Statement st=con.createStatement();
		// 4. SQL Execute (select )
		ResultSet rs=st.executeQuery("select * from emp");
		
		// 5. result
		while(rs.next()){
			System.out.println(rs.getString("ename")+" : "+rs.getInt("empno"));
		}
		// 6. close
		rs.close();
		st.close();
		con.close();
	}

}
