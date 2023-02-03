package com.jdbc.day32.cms.obj;


public interface DAO {
	public void insertCustomer(Customer c);
	public Customer viewCustomer(int num) ;
	public void viewCustomer() ;
	public void deleteCustomer(int num);
	public void updateCustomer(Customer c);
}