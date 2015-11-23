package com.ncs.innerclass;

public class testLocalInnerClass {

	public static void main(String[] args) {
		LocalInnerClass innerClass = new LocalInnerClass();
		innerClass.test();
	}
}

class LocalInnerClass{
	
	private String name = "Guang Ping";
	
	public void test(){
		final int a = 0;
		class InnerClass{
			public void test(){
				System.out.println(name);
				System.out.println(a);
			}
		}
		
		new InnerClass().test();
	}
}
