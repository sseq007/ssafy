package com.jdbc.day31.cms.para;


class CustTest{
	public static void main(String[] args) throws Exception	{
		CustomerDAO  dao=new CustomerDAO();
		dao.insertCustomer(1314,"홍길동","역삼동");
		dao.insertCustomer(1315,"고길동","하남시");
		dao.insertCustomer(1316,"둘리","천호동");
		//dao.viewCustomer(1315);
		//dao.deleteCustomer(1315);
		dao.viewCustomer();
	}
}
