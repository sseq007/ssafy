package com.jdbc.day21.meta;
import java.sql.*;

public class DBMeta {
	
	public DBMeta () {
	try {
       String driverName = "com.mysql.cj.jdbc.Driver";
	   Class.forName(driverName);
      String dbURL = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	  Connection conn = DriverManager.getConnection
	  (dbURL, "ssafy","ssafy");
	  DatabaseMetaData dbmd = conn.getMetaData();
	  System.out.println(dbmd.getDriverName());
	  System.out.println(dbmd.getDriverVersion());
	  System.out.println(dbmd.getUserName());
	  System.out.println(dbmd.getDatabaseProductName());
      System.out.println(dbmd.getURL());

	  if(dbmd.supportsResultSetConcurrency(
			ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_UPDATABLE))
		System.out.println("������");
	  else 
		  System.out.println("��������");
 

  		conn.close();
	}catch(Exception e){e.printStackTrace();}
	
	}
	
	public static void main(String args[]){
		DBMeta me=new DBMeta();
	}
}

