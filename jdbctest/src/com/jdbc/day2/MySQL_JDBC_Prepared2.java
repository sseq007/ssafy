package com.jdbc.day2;
import  java.sql.*;

class  MySQL_JDBC_Prepared2{
	public static void main(String[] args) 	throws Exception{
		Connection con= null;
		PreparedStatement  st=null;
		ResultSet  rs2= null;
		//1. Driver ����
		try {
			//1. Driver 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. Connection 연결
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
			String query1="Insert into dept (deptno, dname) values(301,'경영')";
			//String query1="Insert into dept (deptno, dname) values(302,?)";
			//String query1="Update dept  set dname=? where dname='경영";
			//String query1="Delete from Departments where Department_id=?";
			st=con.prepareStatement(query1);
			//3. Query 실행
			st.setString(1, "300");
			int  rs=st.executeUpdate(); // excuteUpdate가 excute보다 좋다 excuteUpdate는 int 반한 excute는 boolean 반환 즉 int로 개수를 셀 수 있다
			//4. 
			System.out.println("성공 : rs="+rs);
			
			//5. Query,조회실행
			String query2="Select * from dept";
			//6. 실행
			rs2=st.executeQuery(query2); 
			//5. 결과보기
			while(	rs2.next()  ){
				int num=rs2.getInt(1);
				String name=rs2.getString(2);
				System.out.println(num+"\t"+name);
			}
			//6.종료
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			//6.close
			if(rs2!=null)try{rs2.close();}catch(Exception  e1){}
			if(st!=null)try{st.close();}catch(Exception  e1){}
			if(con!=null)try{con.close();}catch(Exception  e1){}
		}
	}
}
