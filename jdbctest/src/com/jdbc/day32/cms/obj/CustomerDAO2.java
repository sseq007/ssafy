package com.jdbc.day32.cms.obj;

import java.sql.*;

/*
 create table customer(
 num  number(4)  primary key,
 name  varchar2(20),
 address  varchar2(200));
 */
public class CustomerDAO2 implements DAO{
	
	public void insertCustomer(Customer c) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionProxy.getConnection();// 2
			String q = "Insert into customer values(?,?,?)";
			ps = con.prepareStatement(q);// 3

			ps.setInt(1, c.getNum());
			ps.setString(2, c.getName());
			ps.setString(3, c.getAddress());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert ����:" + e);
		} finally {
			try {
				// if(rs != null) rs.close();//6
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public Customer viewCustomer(int num) {
		// num�� �ش��ϴ� ������ ���
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Customer c = null;
		try {
			con = ConnectionProxy.getConnection();// 2
			String q = "Select * from customer where num=" + num;// 3
			st = con.createStatement();// 3
			rs = st.executeQuery(q);// 4
			if (rs.next()) {// 5
				c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
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
		return c;
	}

	public void viewCustomer() {
		// ��ü ������ ���
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ConnectionProxy.getConnection();// 2
			String q = "Select * from customer";// 3
			st = con.createStatement();// 3
			rs = st.executeQuery(q);// 4
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
		Statement st = null;
		try {
			con = ConnectionProxy.getConnection();// 2
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
		}// end finally
	}// end deleteCustomer()

	public void updateCustomer(Customer c) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionProxy.getConnection();
			String q = "Update customer set name=?,address=? where num=?";
			ps = con.prepareStatement(q);
			ps.setString(1, c.getName());
			ps.setString(2, c.getAddress());
			ps.setInt(3, c.getNum());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update ����:" + e);
		} finally {
			try {
				// if(rs != null) rs.close();//6
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}// end finally
	}// end updateCustomer()
}// end class
