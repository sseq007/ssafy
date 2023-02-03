package com.homework0203.db;

import java.sql.*;

import com.homework0203.NameNotFoundException;

/*
 create table customer(
 num  number(4)  primary key,
 name  varchar2(20),
 address  varchar2(200));
 */
public class UserDAO {
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

	public UserDAO() {
	}

	private Connection getConnection() throws SQLException {// 2
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
		return con;
	}

	public void insertUser(String id, String password,String name, String email, int age) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = getConnection();// 2
			String q = "Insert into user values(?,?,?,?,?) ";
			st = con.prepareStatement(q);
			st.setString(1, id);
			st.setString(2, password );
			st.setString(3, name);
			st.setString(4, email);
			st.setInt(5, age);
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
	public void insertVipUser(String id, String password,String name, String email, int age,String grade,int point ) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = getConnection();// 2
			String q = "Insert into vipuser values(?,?,?,?,?,?,?) ";
			st = con.prepareStatement(q);
			st.setString(1, id);
			st.setString(2, password );
			st.setString(3, name);
			st.setString(4, email);
			st.setInt(5, age);
			st.setString(6, grade);
			st.setInt(7, point);
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

	public void viewUsername(String name) throws NameNotFoundException {
		// num�� �ش��ϴ� ������ ���
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int count=0;
		try {
			con = getConnection();// 2
			String q = "Select * from user where name=?";// 3
			st = con.prepareStatement(q);
			 st.setString(1, name);
			rs = st.executeQuery();// 4
			
			while(rs.next()) {// 5
				if(rs.getString(3).contains(name)) {
					count+=1;
//					System.out.println(count);
					System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t"
							+ rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5));
				}
			
			}
			if(count==0) {
				throw new NameNotFoundException(name);
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
	
	public void searchAgeAvg() {
		// num�� �ش��ϴ� ������ ���
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		double sum=0;
		int n=0;
		try {
			con = getConnection();// 2
			String q = "Select age from user";// 3
			st= con.prepareStatement(q);
			rs = st.executeQuery();// 4
			
			while (rs.next()) {// 5
				sum+=rs.getInt("age");
				n+=1;
				
			}
			System.out.println(sum/n);
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

	public void viewUser() {
		// ��ü ������ ���
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = getConnection();// 2
			String q = "Select * from user";// 3
			st = con.prepareStatement(q);
			rs = st.executeQuery();// 4
			while (rs.next()) {// 5
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5));
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

//	public void deleteCustomer(int num) {
//		// num�� �ش��ϴ� �� ����
//		Connection con = null;
//		PreparedStatement st = null;
//		try {
//			con = getConnection();// 2
//			String q = "Delete from customer  where num=" + num;// 3
//			st = con.prepareStatement(q);// 3
//			st.executeUpdate();// 4
//		} catch (SQLException e) {
//			System.out.println("delete ����:" + e);
//		} finally {
//			try {
//				// if(rs != null) rs.close();//6
//				if (st != null)
//					st.close();
//				if (con != null)
//					con.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}// end finally
//
//	}// end deleteCustomer()
}// end class
