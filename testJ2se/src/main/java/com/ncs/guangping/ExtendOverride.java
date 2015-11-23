package com.ncs.guangping;

public class ExtendOverride {
	public static void main(String[] args) {
		Parent p = new Child("GuangPing");
		p.fun();
	}
}

class Parent {
	private String name;

	public Parent() {
	}

	public Parent(String name) {
		this.name = name;
	}

	private void say() {
		System.out.println("Parent..." + name);
	}

	public void fun() {
		this.say();
	}
}

class Child extends Parent {
	private String name;

	public Child(String name) {
		this.name = name;
	}

	public void say() {
		System.out.println("Child..." + name);
	}
	
}