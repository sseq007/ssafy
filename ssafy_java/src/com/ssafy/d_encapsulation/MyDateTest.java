package com.ssafy.d_encapsulation;

class MyDate{
	private int year;
	private int month;
	protected int day;
	public MyDate() {
		
	}
	public MyDate(int year, int month, int day) {
		setYear(year);
		setDay(day);
		setMonth(month);
		 
	}
	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		
		if(month<1||month>12) {
			System.out.println("입력을 잘못 입력하셨습니다");
			return;
		}
		this.month = month;
		
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	
}
class YourDate extends MyDate{
	boolean isHoliyday;
	public YourDate(int year,int month,int day,boolean isHoliyDay) {
		//super(year,month,day);
		super.setYear(year);
		super.setMonth(month);
		super.day=day;
		this.isHoliyday=isHoliyDay;
	}
	
}
public class MyDateTest {

	public static void main(String[] args) {
		
		MyDate d = new MyDate(2023,1,18);
		
//		d.month=08; 8진수 이기 떄문에 08 int형일떄 사용 x
		
		System.out.println(d);
	}
}
