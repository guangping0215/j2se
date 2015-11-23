package com.ncs.decorator;

public class DecoratorA extends Decorator{

	protected DecoratorA(Component component) {
		super(component);
	}

	public void doSomething() {
		
		component.doSomething();
		doSomethinga();
	}
	public void doSomethinga() {
		System.out.println("DecoratorA do something...");
	}
}
