package com.ncs.guangping;

public class StringPoolTest {

	public static void main(String[] args) {
		
		String test1 = "guangping1";
		System.out.println(test1 == "guangping1");
		
		String test2 = new String("guangping1");
		System.out.println(test2 == test1);
		
		String test3 = test2.intern();
		System.out.println(test1 == test3);
		System.out.println(test2 == test3);
	}
}
