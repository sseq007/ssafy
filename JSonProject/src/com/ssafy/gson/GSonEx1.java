package com.ssafy.gson;

import com.google.gson.Gson;

public class GSonEx1 {
	public static void main(String[] args) {
		//기본타입을 JSON으로 바꾼다.
		// Serialization
		Gson gson = new Gson();
		gson.toJson(1);            // ==> 1
		gson.toJson("abcd");       // ==> "abcd"
		gson.toJson(new Long(10)); // ==> 10
		int[] values = { 1 };
		gson.toJson(values);       // ==> [1]

		//JSON을 기본타입으로 바꾼다.
		// Deserialization
		int one = gson.fromJson("1", int.class);
		Integer onei = gson.fromJson("1", Integer.class);
		Long oneL = gson.fromJson("1", Long.class);
		Boolean boo = gson.fromJson("false", Boolean.class);
		String str = gson.fromJson("\"abc\"", String.class);
		String anotherStr = gson.fromJson("[\"abc\"]", String.class);

		
	
	}
}
