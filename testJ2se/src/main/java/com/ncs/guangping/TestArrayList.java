package com.ncs.guangping;

import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("1");
		testList.add("2");
		testList.add("3");
		testList.add("4");
		testList.add("5");
		String[] arrs = new String[]{"11","12","13","14","15","16","17","18"};
		String[] arrs2 = testList.toArray(arrs);
		
	 Integer t1 = 200;
	 Integer t2 = 200;
	 
	 System.out.println(t1 == t2);
	}
}
