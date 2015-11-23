package com.ncs.decorator;

public class Client {

	public static void main(String[] args) {
		Component test = new ConcreteComponent();
		test.doSomething();
		
		System.out.println("===========");
		Component test2 = new DecoratorA(new ConcreteComponent());
		test2.doSomething();
		
		System.out.println("===========");
		Component test3 = new DecoratorB(new ConcreteComponent());
		test3.doSomething();
		
		System.out.println("===========");
		Component test4 = new DecoratorB(new DecoratorA(new ConcreteComponent()));
		test4.doSomething();
	}
	
}
