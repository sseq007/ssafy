package com.jdbc.day31.cms.para;
public class Customer{
	private int num;
	private String name;
	private String address;

	public Customer(){}
	public Customer(int num, String name, String address){
		setNum(num);
		setName(name);
		setAddress(address);
	}
	public void setNum(int num){
		this.num=num;
	}
	public  int   getNum(){
		return num;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public String toString(){
		String msg=num+"\t"+name+"\t"+address;
		return msg;
	}
}
