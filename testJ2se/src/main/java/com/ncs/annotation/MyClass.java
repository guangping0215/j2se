package com.ncs.annotation;

@MyAnnotation(name = "MyClass")
public class MyClass {

	@MyAnnotation(name = "test")
	public void test(){
		System.out.println("test .....");
	}
	
	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		myClass.test();
	}
}
