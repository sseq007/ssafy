package com.ssafy.gson;

public class Member {
	String num;
	String name;
	String age;
	String addr;
	public Member(String num, String name, String age, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public Member() {
		super();
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
}
