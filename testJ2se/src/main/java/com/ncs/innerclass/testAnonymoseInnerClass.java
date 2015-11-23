package com.ncs.innerclass;


public class testAnonymoseInnerClass {

	public static void main(String[] args) {
		AnonymoseInnerClass innerclass = new AnonymoseInnerClass();
		innerclass.test(new Pension(){
			@Override
			public void sayName() {
				System.out.println("test...");
			}
		});
	}
}

class AnonymoseInnerClass{
	
	public void test(Pension persion){
		persion.sayName();
	}
}

class Pension{
	String name;

	public void sayName(){
		System.out.println("Say..."+name);
	}
	
}