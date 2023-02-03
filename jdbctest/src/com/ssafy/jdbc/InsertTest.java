package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

	
	public InsertTest() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		}
	}
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		
		int cnt = it.register("신준호",26);
		if(cnt !=0) {
			System.out.println("등록 성공");
		}else System.out.println("등록 실패");
		
	}
	
	private int register(String name, int age) {
		int cnt=0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//DB 연결
			conn=getConnection();
			StringBuilder sql =new StringBuilder("insert into jdbtest(name,age) \n") ;
			sql.append("values (?,?)");
			//SQL 실행 준비
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			//SQL 실행
			cnt = pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}
	private Connection getConnection() throws SQLException {
		
		return	DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC", "ssafy","ssafy");
		
			
		 
	}
}
