package com.ncs.innerclass;

import com.ncs.innerclass.StaticInnerClass.InnerClass;

public class testStaticInnerClass {
	
	public static void main(String[] args) {
		InnerClass innerClass = new StaticInnerClass.InnerClass();
		innerClass.test();
	}
}

class StaticInnerClass{
	
	private static String name = "Guang Ping";
	
	public static class InnerClass{
		
		public void test(){
			System.out.println(name);
		}
	}
}