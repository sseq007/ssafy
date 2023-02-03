package com.jdbc.day21.meta;
import java.sql.*;
public class ResultMeta{
	public static void main(String args[]) throws 
	           ClassNotFoundException,SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
		Statement stmt=con.createStatement();
		ResultSet rset=stmt.executeQuery(
					"SELECT * FROM employees");
		ResultSetMetaData rsmd=rset.getMetaData();
		
		int columnCount=rsmd.getColumnCount();
		System.out.println(columnCount+"���� column");
		rset.next();
		for(int i=1;i<=columnCount;i++){
			System.out.println(rset.getString(i)+":Column("+i+"): "+
			         rsmd.getColumnName(i)
					+"  "+rsmd.getColumnTypeName(i));	
		}
		stmt.close();
		con.close();
	}	
}
