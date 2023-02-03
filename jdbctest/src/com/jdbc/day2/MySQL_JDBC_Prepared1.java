package com.jdbc.day2;
import  java.sql.*;

class  MySQL_JDBC_Prepared1{
	public static void main(String[] args) 	{
		Connection con=null;
		PreparedStatement  st=null;
		ResultSet  rs=null;
		try{
			//1. Driver 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. Connection 연결
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
			//3. create Query, 
			String query="Select * from dept where deptno = ?";
			st=con.prepareStatement(query);
			st.setInt(1, 10);
			//4. Query 실행
			rs=st.executeQuery();
			//5. 조회결과처리
			while(	rs.next()  ){
				int num=rs.getInt(1);
				String name=rs.getString("dname");
				System.out.println(num+"\t"+name);
			}
		}catch(ClassNotFoundException e){
			System.out.println("JDBC Class Loading 실패.");
		}catch(SQLException ee){
			System.out.println("DB SQL Error");
			ee.printStackTrace();
		}finally{
			//6.close
			try{	
				if(rs !=null) rs.close();
				if(st !=null) st.close();
				if(con !=null) con.close();
			}catch(SQLException e){e.printStackTrace();}
		}//end finally
	}//end main
}//end class
