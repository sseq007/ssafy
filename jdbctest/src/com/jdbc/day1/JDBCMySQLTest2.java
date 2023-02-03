package com.jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCMySQLTest2 {

	public static void main(String[] args)throws Exception {
		// 1. Driver Loading
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. Connection 
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
		// 3. Statement Create
		Statement st=con.createStatement();
		// 4. SQL Execute (except select)
		st.execute("insert into emp(empno, ename, sal) values (9999,'홍길동',1000)");
		
		// 5. close
		st.close();
		con.close();
	}

}
