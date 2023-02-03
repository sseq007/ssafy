package com.jdbc.day31.cms.para;

import java.sql.*;

/*
 create table customer(
 num  number(4)  primary key,
 name  varchar2(20),
 address  varchar2(200));
 */
public class CustomerDAO {
	//static block은 실행이 한번만 된다.
	static {
		try {
			//1. Driver 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. Connection 연결
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}// 1
	}

	public CustomerDAO() {
	}

	private Connection getConnection() throws SQLException {// 2
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
		return con;
	}

	public void insertCustomer(int num, String name, String address) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = getConnection();// 2
			String q = "Insert into customer values(?,?,?) ";
			st = con.prepareStatement(q);
			st.setInt(1, num);
			st.setString(2, name);
			st.setString(3, address);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert SQL error:" + e);
		} finally {
			try {
				// if(rs != null) rs.close();//6
				if (st != null)		st.close();
				if (con != null)	con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void viewCustomer(int num) {
		// num�� �ش��ϴ� ������ ���
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = getConnection();// 2
			String q = "Select * from customer where num=?";// 3
			st = con.prepareStatement(q);
			 st.setInt(1, num);
			rs = st.executeQuery();// 4
			if (rs.next()) {// 5
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("select ����:" + e);
		} finally {
			try {
				if (rs != null)
					rs.close();// 6
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	public void viewCustomer() {
		// ��ü ������ ���
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = getConnection();// 2
			String q = "Select * from customer";// 3
			st = con.prepareStatement(q);
			rs = st.executeQuery();// 4
			while (rs.next()) {// 5
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("select ����:" + e);
		} finally {
			try {
				if (rs != null)
					rs.close();// 6
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void deleteCustomer(int num) {
		// num�� �ش��ϴ� �� ����
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = getConnection();// 2
			String q = "Delete from customer  where num=" + num;// 3
			st = con.prepareStatement(q);// 3
			st.executeUpdate();// 4
		} catch (SQLException e) {
			System.out.println("delete ����:" + e);
		} finally {
			try {
				// if(rs != null) rs.close();//6
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}// end finally

	}// end deleteCustomer()
}// end class
