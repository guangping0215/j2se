package com.ncs.template;

public abstract class AbstractClass {

	
	public void template(){
		this.method1();
		this.method2();
		this.method3();
	}
	
	protected void method1(){
		System.out.println("abstract method 1");
	}
	protected abstract void method2();
	protected abstract void method3();
}
