package com.jdbc.day32.cms.obj;

import java.sql.*;

/*
create table customer(
		num  number(4)  primary key,
		name  varchar2(20),
		address  varchar2(200));
*/
public class CustomerDAO1 implements DAO{
	public CustomerDAO1() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	private Connection getConnection() throws SQLException {// 2

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/hr?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "exam",
				"exam");
		return con;
	}

	public void insertCustomer(Customer c) {
		Connection con = null;
		Statement st = null;
		try {
			con = getConnection();// 2
			String q = "Insert into customer values(" + c.getNum() + ",'" + c.getName() + "','" + c.getAddress() + "')";
			st = con.createStatement();// 3
			st.executeUpdate(q);
		} catch (SQLException e) {
			System.out.println("insert 에러:" + e);
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
		}
	}

	public Customer viewCustomer(int num) {
		// num 을 이용한 조회
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Customer c = null;
		try {
			con = getConnection();// 2
			String q = "Select * from customer where num=" + num;// 3
			st = con.createStatement();// 3
			rs = st.executeQuery(q);// 4
			if (rs.next()) {// 5
				c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("select SQL error:" + e);
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
		return c;
	}

	public void viewCustomer() {
		// ��ü ������ ���
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = getConnection();// 2
			String q = "Select * from customer";// 3
			st = con.createStatement();// 3
			rs = st.executeQuery(q);// 4
			while (rs.next()) {// 5
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
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
		Statement st = null;
		try {
			con = getConnection();// 2
			String q = "Delete from customer  where num=" + num;// 3
			st = con.createStatement();// 3
			st.executeUpdate(q);// 4
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
		} // end finally
	}// end deleteCustomer()

	public void updateCustomer(Customer c) {
		Connection con = null;
		Statement st = null;
		try {
			con = getConnection();
			String q = "Update customer set name='" + c.getName() + "',address='" + c.getAddress() + "'  where num="
					+ c.getNum();
			st = con.createStatement();
			st.executeUpdate(q);
		} catch (SQLException e) {
			System.out.println("update ����:" + e);
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
		} // end finally
	}// end updateCustomer()
}// end class
