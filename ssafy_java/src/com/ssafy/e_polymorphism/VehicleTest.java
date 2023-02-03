package com.ssafy.e_polymorphism;

public class VehicleTest {

	public static void main(String[] args) {
	
		Vehicle[] vehicles = {new DieselSUV(),new ElectricCar()};
		
		for(Vehicle v: vehicles) {
			v.reportPostition();
			v.addFuel();
//			if(v instanceof DieselSUV) {
//				DieselSUV d= (DieselSUV)v;
//			}else if (v instanceof ElectricCar) {
//				ElectricCar e = (ElectricCar)v;
//				e.addFuel();
//			}
		}

	}

}
