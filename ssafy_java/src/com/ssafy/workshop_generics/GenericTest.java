package com.ssafy.workshop_generics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GenericTest {

	public static void main(String[] args) {
		
		Stack<?>s = new Stack<>();
//		s.push(s);
		s.pop();
		
		Queue<?> q = new LinkedList<>();
	}
}
