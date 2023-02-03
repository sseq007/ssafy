package com.jdbc.day32.cms.obj;

class CustTest2 
{
	public static void main(String[] args) throws Exception
	{
		CustomerDAO2  dao=new CustomerDAO2();
		dao.insertCustomer(new Customer(1314,"ȫ�浿","����"));
		dao.insertCustomer(new Customer(1315,"�ҳ���","�λ�"));
		dao.insertCustomer(new Customer(1316,"������","�λ�"));
		Customer c=dao.viewCustomer(1315);
		System.out.println(c);
		dao.deleteCustomer(1315);
		dao.updateCustomer(new Customer(1314,"ȫ�浿","��õ"));
		dao.viewCustomer();
	}
}
